package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Survey(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<SurveyItem>,
//    @SerializedName("error") val error: String,
)