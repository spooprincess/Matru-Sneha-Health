package com.matrusneh

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.preference.PreferenceManager
import com.matrusneh.data.AppDatabase
import com.matrusneh.work.CheckupReminderWorker

class MatruSnehApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Apply stored locale early.
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val lang = prefs.getString("pref_lang", "en") ?: "en"
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(lang))

        // Initialize DB once (lazy init happens on first access too).
        AppDatabase.getInstance(this)

        // Ensure notification channel exists.
        CheckupReminderWorker.ensureChannel(this)
    }
}

