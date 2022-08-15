package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Chatbot(
    @SerializedName("Answer") val Answer: String,
)