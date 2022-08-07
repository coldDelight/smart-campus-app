package com.example.smart_campus.model

data class Login(
    val success: String,
    val response : UserInfo,
    val error: String
)