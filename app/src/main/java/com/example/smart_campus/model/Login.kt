package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("response") val response: LoginItem
)