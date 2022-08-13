package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Notice(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<NoticeItem>,
//    @SerializedName("error") val error: String,
)