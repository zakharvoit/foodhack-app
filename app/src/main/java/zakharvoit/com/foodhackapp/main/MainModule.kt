package zakharvoit.com.foodhackapp.main

import org.koin.dsl.module.applicationContext

val mainModule = applicationContext {
    provide { MainActivity() }
}