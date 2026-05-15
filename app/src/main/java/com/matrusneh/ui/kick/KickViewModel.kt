package com.matrusneh.ui.kick

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.matrusneh.data.AppDatabase
import com.matrusneh.data.kick.KickLog
import com.matrusneh.util.DateTimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class KickUiState(
    val totalToday: Int = 0,
    val lastKickText: String = "-",
    val rows: List<KicksPerHourRow> = emptyList()
)

data class KicksPerHourRow(
    val dayIso: String,
    val hourLabel: String,
    val count: Int
)

class KickViewModel(app: Application) : AndroidViewModel(app) {
    private val kickDao = AppDatabase.getInstance(app).kickDao()

    private val _state = MutableLiveData(KickUiState())
    val state: LiveData<KickUiState> = _state

    private val timeFmt = SimpleDateFormat("hh:mm a", Locale.getDefault())
    private val hourFmt = SimpleDateFormat("hh a", Locale.getDefault())

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            val start = DateTimeUtils.startOfTodayMillis()
            val end = DateTimeUtils.endOfTodayMillisExclusive()

            val total = kickDao.countBetween(start, end)
            val last = kickDao.lastKickBetween(start, end)
            val lastText = last?.let { timeFmt.format(Date(it)) } ?: "-"

            val sevenDaysAgo = start - 6L * 24L * 60L * 60L * 1000L
            val stamps = kickDao.timestampsSince(sevenDaysAgo)

            val grouped = stamps.groupBy { ts ->
                val day = DateTimeUtils.formatMillisToIso(ts)
                val hour = DateTimeUtils.floorToHour(ts)
                day to hour
            }.map { (key, list) ->
                val (dayIso, hourMillis) = key
                KicksPerHourRow(
                    dayIso = dayIso,
                    hourLabel = hourFmt.format(Date(hourMillis)),
                    count = list.size
                )
            }.sortedWith(compareByDescending<KicksPerHourRow> { it.dayIso }.thenByDescending { it.hourLabel })

            _state.postValue(KickUiState(total, lastText, grouped))
        }
    }

    fun logKick(now: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            kickDao.insert(KickLog(timestamp = now))
            refresh()
        }
    }
}

