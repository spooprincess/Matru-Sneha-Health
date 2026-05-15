package com.matrusneh.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.matrusneh.data.checkup.CheckupDao
import com.matrusneh.data.checkup.CheckupRecord
import com.matrusneh.data.kick.KickDao
import com.matrusneh.data.kick.KickLog
import com.matrusneh.data.nutrition.NutritionDao
import com.matrusneh.data.nutrition.NutritionLog

@Database(
    entities = [KickLog::class, CheckupRecord::class, NutritionLog::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun kickDao(): KickDao
    abstract fun checkupDao(): CheckupDao
    abstract fun nutritionDao(): NutritionDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "matru_sneh.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

