package com.example.smart_campus.data.network

import com.example.smart_campus.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GroupObject {
    private const val BASE_URL = BuildConfig.BASE_URL
    var token: String = ""
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.NONE
    }).addInterceptor {
        // Request
        val request = it.request()
            .newBuilder()
            .addHeader("jwt_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJTVFVERU5UX0lEIjoiMjAxNzEzMDIiLCJOTSI6Iu2ZjeyasOyEsSIsIkxFVkVMIjo4LCJERVBUX05NIjoi7Lu07ZOo7YSw6rO17ZWZ67aAIiwiU0NIWVIiOiI0IiwiaWF0IjoxNjU5OTAyOTA5LCJleHAiOjE2NjExMTI1MDksImlzcyI6IkhPU0VPTk9USUNFIn0.zR26QU5ODDhr9rRvupEL_EIeHo-a_LebuAt77bxqu7I")
            .build()

        // Response
        val response = it.proceed(request)
        response
    }.build()

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService : GroupInterface by lazy{
        getRetrofit.create(GroupInterface::class.java)
    }
}