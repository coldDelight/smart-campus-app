package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Notice(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<NoticeItem>,
//    @SerializedName("error") val error: String,
)
data class NoticeItem (
    @SerializedName("notice_id") val  notice_id: String,
    @SerializedName("title") val  title: String,
    @SerializedName("create_time") val   create_time: String,
    @SerializedName("file_count") val   file_count: String
)