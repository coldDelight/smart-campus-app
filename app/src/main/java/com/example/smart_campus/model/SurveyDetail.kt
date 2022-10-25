package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class SurveyDetail(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<SurveyDetailItem>,
//    @SerializedName("error") val error: String,
)
data class SurveyDetailItem(
    @SerializedName("survey_question_id") val  id: Int,
    @SerializedName("question") val  question: String,
    @SerializedName("type_name") val  type_name: String,
    @SerializedName("choice_content") val   choice_content: List<String>,
)