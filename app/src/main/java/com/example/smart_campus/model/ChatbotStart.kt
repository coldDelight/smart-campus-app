package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class ChatbotStart(
    @SerializedName("message") val message: String,
)