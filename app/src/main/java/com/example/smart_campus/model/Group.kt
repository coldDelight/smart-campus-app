package com.example.smart_campus.model

import com.google.gson.annotations.SerializedName

data class Group(
//    @SerializedName("success") val success: String,
    @SerializedName("response") val response: List<GroupItem>,
//    @SerializedName("error") val error: String,
    )

data class GroupItem(
    @SerializedName("group_id") val  group_id: String,
    @SerializedName("group_name") val  group_name: String,
    @SerializedName("intro") val  intro: String
)