package com.zakharvoit.paydrivers

import android.app.Application
import org.koin.Koin
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger
import zakharvoit.com.foodhackapp.foodhackModules

class FoodhackApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Koin.logger = AndroidLogger()
        startKoin(this, foodhackModules)
    }
}