package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Group(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<GroupItem>,
//    @SerializedName("error") val error: String,
    )
