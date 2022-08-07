package com.example.smart_campus.model

data class UserInfo(
    val user_id : String,
    val name: String,
    val department: String,
    val grade: String,
    val jwt_token: String,
    val accept: String,

)

