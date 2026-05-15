package com.matrusneh.data.kick

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kick_logs")
data class KickLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long
)

