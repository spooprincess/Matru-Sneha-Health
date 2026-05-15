package com.matrusneh.data.nutrition

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nutrition_logs")
data class NutritionLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val dateIso: String,
    val ragi: Boolean,
    val greens: Boolean,
    val pulses: Boolean,
    val milk: Boolean,
    val fruits: Boolean
)

