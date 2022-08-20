package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class LoginItem(
    @SerializedName("user_id") val  user_id: String,
    @SerializedName("name") val  name: String,
    @SerializedName("department") val  department: String,
    @SerializedName("grade") val  grade: String,
    @SerializedName("jwt_token") val  jwt_token: String,
    @SerializedName("accept") val  accept: String
)

