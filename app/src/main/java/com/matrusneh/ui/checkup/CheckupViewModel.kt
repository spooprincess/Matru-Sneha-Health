package com.matrusneh.ui.checkup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.matrusneh.data.AppDatabase
import com.matrusneh.data.checkup.CheckupRecord
import com.matrusneh.util.DateTimeUtils
import com.matrusneh.work.CheckupReminderWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

data class CheckupUiState(
    val lastDateIso: String = "",
    val nextDateIso: String = "",
    val daysRemaining: Int? = null
)

class CheckupViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = AppDatabase.getInstance(app).checkupDao()
    private val workManager = WorkManager.getInstance(app)

    private val _state = MutableLiveData(CheckupUiState())
    val state: LiveData<CheckupUiState> = _state

    private val intervalDays = 28

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            val latest = dao.latest()
            if (latest == null) {
                _state.postValue(CheckupUiState())
                return@launch
            }
            _state.postValue(toState(latest.lastDateIso, latest.nextDateIso))
        }
    }

    fun setLastDate(lastIso: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val lastMillis = DateTimeUtils.parseIsoToMillis(lastIso)
            val nextMillis = lastMillis + intervalDays * 24L * 60L * 60L * 1000L
            val nextIso = DateTimeUtils.formatMillisToIso(nextMillis)

            dao.clear()
            dao.upsert(CheckupRecord(lastDateIso = lastIso, nextDateIso = nextIso))
            _state.postValue(toState(lastIso, nextIso))

            scheduleReminderOneDayBefore(nextMillis)
        }
    }

    private fun toState(lastIso: String, nextIso: String): CheckupUiState {
        val now = System.currentTimeMillis()
        val nextMillis = DateTimeUtils.parseIsoToMillis(nextIso)
        val diffDays = ((nextMillis - now) / (24L * 60L * 60L * 1000L)).toInt()
        return CheckupUiState(
            lastDateIso = lastIso,
            nextDateIso = nextIso,
            daysRemaining = diffDays
        )
    }

    private fun scheduleReminderOneDayBefore(nextMillis: Long) {
        val remindAt = nextMillis - 24L * 60L * 60L * 1000L
        val delay = (remindAt - System.currentTimeMillis()).coerceAtLeast(5_000L)

        val req = OneTimeWorkRequestBuilder<CheckupReminderWorker>()
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()

        workManager.enqueueUniqueWork(
            UNIQUE_WORK,
            ExistingWorkPolicy.REPLACE,
            req
        )
    }

    companion object {
        const val UNIQUE_WORK = "checkup_reminder_one_day_before"
    }
}

