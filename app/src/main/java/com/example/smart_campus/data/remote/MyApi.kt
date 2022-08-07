package com.example.smart_campus.data.remote

import retrofit2.http.GET

interface MyApi  {

    @GET("test")
    suspend fun doNetWorkCall()
}