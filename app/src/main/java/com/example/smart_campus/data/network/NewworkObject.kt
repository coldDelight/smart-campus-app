package com.example.smart_campus.data.network

import com.example.smart_campus.BuildConfig
import com.example.smart_campus.SmartCampusApp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//뭔가 다같이 쓰기 가능
object NewworkObject {
    private const val BASE_URL = BuildConfig.BASE_URL
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).addInterceptor {
        // Request
        val request = it.request()
            .newBuilder()
//            .addHeader("jwt_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJTVFVERU5UX0lEIjoiMjAxNzEzMDIiLCJOTSI6Iu2ZjeyasOyEsSIsIkxFVkVMIjo4LCJERVBUX05NIjoi7Lu07ZOo7YSw6rO17ZWZ67aAIiwiU0NIWVIiOiI0IiwiaWF0IjoxNjU5OTAyOTA5LCJleHAiOjE2NjExMTI1MDksImlzcyI6IkhPU0VPTk9USUNFIn0.zR26QU5ODDhr9rRvupEL_EIeHo-a_LebuAt77bxqu7I")
            .addHeader("jwt_token", SmartCampusApp.prefs.token?:"")
            .build()

        // Response
        val response = it.proceed(request)
        response
    }.connectTimeout(20,TimeUnit.SECONDS).
    readTimeout(20,TimeUnit.SECONDS).
    writeTimeout(20,TimeUnit.SECONDS).
    build()

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val getRetrofitChat by lazy{
        Retrofit.Builder()
            .baseUrl(BuildConfig.CHAT_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService : ApiInterface by lazy{
        getRetrofit.create(ApiInterface::class.java)
    }

    val getRetrofitServiceChat : ApiInterface by lazy{
        getRetrofitChat.create(ApiInterface::class.java)
    }
}