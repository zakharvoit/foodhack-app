package zakharvoit.com.foodhackapp.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

fun createFoodhackApi(): FoodhackApi {
    val retrofit = Retrofit.Builder()
            .baseUrl("http://94.250.250.220")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    return retrofit.create(FoodhackApi::class.java)
}
