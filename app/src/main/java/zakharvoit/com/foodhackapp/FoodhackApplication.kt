package zakharvoit.com.foodhackapp

import android.app.Application
import org.koin.Koin
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class FoodhackApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Koin.logger = AndroidLogger()
        startKoin(this, foodhackModules)
    }
}