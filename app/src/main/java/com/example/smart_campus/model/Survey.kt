package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Survey(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<SurveyItem>,
//    @SerializedName("error") val error: String,
)
data class SurveyItem(
    @SerializedName("survey_id") val  survey_id: String,
    @SerializedName("title") val  title: String,
    @SerializedName("create_time") val   create_time: String,
    @SerializedName("end_time") val   end_time: String
)