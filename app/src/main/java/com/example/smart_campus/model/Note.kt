package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Note(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<NoteItem>,
//    @SerializedName("error") val error: String,
)
