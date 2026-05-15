package com.matrusneh.ui.nutrition

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.matrusneh.data.AppDatabase
import com.matrusneh.data.nutrition.NutritionLog
import com.matrusneh.util.DateTimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.math.abs

data class NutritionUiState(
    val dateIso: String = "",
    val ragi: Boolean = false,
    val greens: Boolean = false,
    val pulses: Boolean = false,
    val milk: Boolean = false,
    val fruits: Boolean = false,
    val weeklyTip: String = ""
)

class NutritionViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = AppDatabase.getInstance(app).nutritionDao()

    private val _state = MutableLiveData(NutritionUiState())
    val state: LiveData<NutritionUiState> = _state

    fun loadToday(tips: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            val dateIso = DateTimeUtils.todayIso()
            val existing = dao.getByDate(dateIso)
            val tip = pickWeeklyTip(tips)
            if (existing == null) {
                _state.postValue(NutritionUiState(dateIso = dateIso, weeklyTip = tip))
            } else {
                _state.postValue(
                    NutritionUiState(
                        dateIso = dateIso,
                        ragi = existing.ragi,
                        greens = existing.greens,
                        pulses = existing.pulses,
                        milk = existing.milk,
                        fruits = existing.fruits,
                        weeklyTip = tip
                    )
                )
            }
        }
    }

    fun saveToday(state: NutritionUiState) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.upsert(
                NutritionLog(
                    dateIso = state.dateIso,
                    ragi = state.ragi,
                    greens = state.greens,
                    pulses = state.pulses,
                    milk = state.milk,
                    fruits = state.fruits
                )
            )
        }
    }

    private fun pickWeeklyTip(tips: List<String>): String {
        if (tips.isEmpty()) return ""
        val weekOfYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)
        val idx = abs(weekOfYear) % tips.size
        return tips[idx]
    }
}

