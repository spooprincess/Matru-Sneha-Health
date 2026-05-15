package com.matrusneh.data.kick

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KickDao {

    @Insert
    suspend fun insert(log: KickLog)

    @Query("SELECT COUNT(*) FROM kick_logs WHERE timestamp BETWEEN :start AND :end")
    suspend fun countBetween(start: Long, end: Long): Int

    @Query("SELECT MAX(timestamp) FROM kick_logs WHERE timestamp BETWEEN :start AND :end")
    suspend fun lastKickBetween(start: Long, end: Long): Long?

    @Query("SELECT timestamp FROM kick_logs WHERE timestamp >= :since ORDER BY timestamp ASC")
    suspend fun timestampsSince(since: Long): List<Long>
}

