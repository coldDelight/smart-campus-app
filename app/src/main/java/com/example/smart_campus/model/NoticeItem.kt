package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class NoticeItem (
    @SerializedName("notice_id") val  notice_id: String,
    @SerializedName("title") val  title: String,
    @SerializedName("create_time") val   create_time: String,
    @SerializedName("file_count") val   file_count: String
    )