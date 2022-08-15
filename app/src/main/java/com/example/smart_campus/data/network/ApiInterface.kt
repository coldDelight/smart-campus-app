package com.example.smart_campus.data.network

import com.example.smart_campus.model.*
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/api/group/user-group-list")
    suspend fun getGroup(): Response<Group>

    @GET("/api/group/all-group-app")
    suspend fun getGroupAll(): Response<Group>

    @GET("/api/push/my-push-log")
    suspend fun getNote(): Response<Note>

    @GET("/api/notice/all-app?group_id=4")
    suspend fun getNotice(): Response<Notice>

    @GET("/api/program/app_program")
    suspend fun getSurvey(): Response<Survey>

    @GET("/hello")
    suspend fun getChatStart(): Response<ChatbotStart>

    @POST("/query/NORMAL")
    suspend fun postCahtbot(@Body query:JsonObject): Response<Chatbot>
}