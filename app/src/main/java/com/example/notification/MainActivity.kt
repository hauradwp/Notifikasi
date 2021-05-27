    package com.example.notification

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this )

        btnSend1.setOnClickListener {
            val tittle = etTittle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this,BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(tittle)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)

            val notification = builder.build()
            notificationManager.notify(1, notification)
        }

        btnSend2.setOnClickListener {
            val tittle = etTittle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(tittle)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)

            val notification = builder.build()
            notificationManager.notify(2, notification)
        }
    }
}