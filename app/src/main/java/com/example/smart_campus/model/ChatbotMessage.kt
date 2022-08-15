package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class ChatbotMessage(
    val mes: String,
    val isUserSend: Boolean,
)