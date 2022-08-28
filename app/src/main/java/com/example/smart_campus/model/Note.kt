package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Note(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<NoteItem>,
//    @SerializedName("error") val error: String,
)
data class NoteItem(
    @SerializedName("push_title") val  push_title: String,
    @SerializedName("push_content") val  push_content: String,
    @SerializedName("push_date") val  push_date: String
)
