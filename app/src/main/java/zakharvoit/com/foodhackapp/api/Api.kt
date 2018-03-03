package zakharvoit.com.foodhackapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

fun createFoodhackApi(): FoodhackApi {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    val httpClient = OkHttpClient.Builder();
    httpClient.addInterceptor(logging)
    val retrofit = Retrofit.Builder()
            .baseUrl("http://94.250.250.220")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()

    return retrofit.create(FoodhackApi::class.java)
}
