package zakharvoit.com.foodhackapp.api

import org.koin.dsl.module.applicationContext

val apiModule = applicationContext {
    provide { createFoodhackApi() }
}