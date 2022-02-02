package com.example.testeapponesignal

import android.content.Intent
import com.onesignal.OneSignal

class OneSignalHandler(application: MyApplication) {

    private val app: MyApplication by lazy {
        application
    }

    private var handler: Runnable? = null

    fun instanceOf() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(app)
        OneSignal.setAppId(BuildConfig.ONESIGNAL_APP_ID)
        OneSignal.unsubscribeWhenNotificationsAreDisabled(true)
        addNotificationOpenedHandle()
    }

    private fun addNotificationOpenedHandle() {
        OneSignal.setNotificationOpenedHandler { notificationResult ->

            notificationResult.notification?.additionalData?.let { jsonAdditionalData ->
                if (jsonAdditionalData.has("product_id")) {
                    val productId = jsonAdditionalData.getString("product_id")
                    addGoToSecondFragment(productId)
                }
            }

            val intent = Intent(Intent(app, MainActivity::class.java))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            app.applicationContext.startActivity(intent)
        }
    }

    private fun addGoToSecondFragment(productId: String) {
        handler = Runnable {
            try {
                FirstFragment.instance?.goToSecondFragment(productId)
            } catch (error: Exception) {
                error.printStackTrace()
            }
        }
    }


    fun runPendingHandlers() {
        handler?.run()
        handler = null
    }

}