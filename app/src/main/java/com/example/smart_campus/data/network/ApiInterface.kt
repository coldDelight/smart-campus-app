package com.example.smart_campus.data.network

import com.example.smart_campus.model.*
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/group/user-group-list")
    suspend fun getGroup(): Response<Group>

    @GET("/api/group/all-group-app")
    suspend fun getGroupAll(): Response<Group>

    @POST("/api/group/add-group")
    suspend fun addGroup(@Body query:JsonObject): Response<GroupEdit>

    @GET("/api/push/my-push-log")
    suspend fun getNote(): Response<Note>

    @GET("/api/notice/all-app")
    suspend fun getNotice(@Query("group_id") group_id: String): Response<Notice>

    @GET("/api/survey/all-app")
    suspend fun getSurvey(@Query("group_id") group_id: String): Response<Survey>

    @GET("/hello")
    suspend fun getChatStart(): Response<ChatbotStart>

    @POST("/query/NORMAL")
    suspend fun postCahtbot(@Body query:JsonObject): Response<Chatbot>

    @POST("/api/auth/login")
    suspend fun postLogin(@Body query:JsonObject): Response<Login>
}