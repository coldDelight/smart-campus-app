package com.example.smart_campus

import com.example.smart_campus.model.Login
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface LoginService {

//    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/api/auth/login")
    fun requestLogin(
        @Body jsonObject: JsonObject
    ) : Call<Login>




}