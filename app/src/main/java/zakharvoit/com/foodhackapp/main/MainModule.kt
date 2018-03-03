package zakharvoit.com.foodhackapp.main

import org.koin.dsl.module.applicationContext
import zakharvoit.com.foodhackapp.MainActivity

val mainModule = applicationContext {
    provide { MainActivity() }
}