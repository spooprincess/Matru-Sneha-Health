package com.matrusneh.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateTimeUtils {
    private val isoDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).apply {
        timeZone = TimeZone.getDefault()
    }

    fun todayIso(): String = isoDate.format(Date())

    fun parseIsoToMillis(iso: String): Long {
        return (isoDate.parse(iso) ?: Date()).time
    }

    fun formatMillisToIso(millis: Long): String = isoDate.format(Date(millis))

    fun startOfTodayMillis(): Long {
        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, 0)
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        return c.timeInMillis
    }

    fun endOfTodayMillisExclusive(): Long = startOfTodayMillis() + 24L * 60L * 60L * 1000L

    fun floorToHour(millis: Long): Long {
        val c = Calendar.getInstance()
        c.timeInMillis = millis
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        return c.timeInMillis
    }
}

