package com.example.testeapponesignal

import android.app.Application
import com.onesignal.OneSignal

class OneSignalHandler(application: Application) {

    private val app: Application by lazy {
        application
    }

    fun configure() {
        //Seta o nível de log para debug e para release
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        //Inicia a instancia do onsignal
        OneSignal.initWithContext(app)
        //Seta a chave do app onesignal (Este que configuramos no module: build.gradle)
        OneSignal.setAppId(BuildConfig.ONESIGNAL_APP_ID)

        //Adiciona manipulador para quando a push for clicada
        addNotificationOpenedHandle()
    }

    private fun addNotificationOpenedHandle() {
        //manipulador de quando a push for clicada
        OneSignal.setNotificationOpenedHandler { notificationResult ->

            //Desta forma analisamos a push que foi clicada e verificamos se ela possui alguma informação adicional
            notificationResult.notification?.additionalData?.let { jsonAdditionalData ->

                //Aqui verificamos se dentro das informações adicionar existe uma propriedade "product_id"
                if (jsonAdditionalData.has("product_id")) {

                    //Desta forma obtemos o valor da informação adicional
                    val productId = jsonAdditionalData.getString("product_id")

                    /*
                    ...
                    A partir daqui você pode fazer qualquer coisa com essas informações
                    */
                }
            }
        }
    }
}