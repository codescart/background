package com.foundercodes.background

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.app.Service
import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {





    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "my_channel_id"
            val channelName = "My Channel"
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            val notification = Notification.Builder(this, channelId)
                .setContentTitle("My Background Service")
                .setContentText("Running in the background")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build()

            startForeground(1, notification)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Return null as this is not a bound service
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Implement your background logic here
        // This is where you can run tasks or perform background operations

        // Return START_STICKY to make sure the service is restarted if it gets killed by the system
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cleanup resources if necessary
    }
}