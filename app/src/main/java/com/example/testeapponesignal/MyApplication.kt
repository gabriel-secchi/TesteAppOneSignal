package com.example.testeapponesignal

import android.app.Application

class MyApplication : Application() {

    // Obtem a classe OneSignalHandler
    private val oneSignalHandler: OneSignalHandler by lazy {
        OneSignalHandler(this)
    }

    // Este método só é executado na criação da aplicação,
    // ou seja, somente na instalação ou execução após a limpeza do app nas configurações do device
    override fun onCreate() {
        super.onCreate()
        //Executa o método de configuração da classe OneSignalHandler
        oneSignalHandler.configure()
    }

    // Aqui eu criei um método publico dentro da application que fornece uma instância
    // da classe do OneSignal
    fun getOnSignalInstance(): OneSignalHandler {
        return oneSignalHandler
    }
}