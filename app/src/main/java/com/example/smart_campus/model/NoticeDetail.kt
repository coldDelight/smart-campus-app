package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class NoticeDetail(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: NoticeDetailItem,
//    @SerializedName("error") val error: String,
)
data class NoticeDetailItem (
    @SerializedName("title") val  title: String,
    @SerializedName("content") val  content: String,
    @SerializedName("create_time") val   create_time: String,
)