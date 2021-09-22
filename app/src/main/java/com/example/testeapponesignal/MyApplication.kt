package com.example.testeapponesignal

import android.app.Application
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal

class MyApplication : Application() {

    private val oneSignalHandler: OneSignalHandler by lazy {
        OneSignalHandler(this)
    }

    override fun onCreate() {
        super.onCreate()
        oneSignalHandler.instanceOf()
    }

    fun getOnSignalInstance(): OneSignalHandler {
        return oneSignalHandler
    }
}