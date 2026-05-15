package com.matrusneh.data.checkup

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CheckupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(record: CheckupRecord)

    @Query("SELECT * FROM checkup_records ORDER BY id DESC LIMIT 1")
    suspend fun latest(): CheckupRecord?

    @Query("DELETE FROM checkup_records")
    suspend fun clear()
}

