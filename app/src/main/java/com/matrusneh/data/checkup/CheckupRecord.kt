package com.matrusneh.data.checkup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checkup_records")
data class CheckupRecord(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val lastDateIso: String,
    val nextDateIso: String
)

