package com.matrusneh.data.nutrition

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NutritionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(log: NutritionLog)

    @Query("SELECT * FROM nutrition_logs WHERE dateIso = :dateIso LIMIT 1")
    suspend fun getByDate(dateIso: String): NutritionLog?
}

