package com.matrusneh.work

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.matrusneh.R

class CheckupReminderWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        ensureChannel(applicationContext)
        val title = applicationContext.getString(R.string.notif_checkup_title)
        val text = applicationContext.getString(R.string.notif_checkup_text)

        val notif = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_heart)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(applicationContext).notify(NOTIF_ID, notif)
        return Result.success()
    }

    companion object {
        const val CHANNEL_ID = "checkup_reminders"
        const val NOTIF_ID = 1001

        fun ensureChannel(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val mgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    context.getString(R.string.notif_channel_checkup),
                    NotificationManager.IMPORTANCE_HIGH
                )
                mgr.createNotificationChannel(channel)
            }
        }
    }
}

