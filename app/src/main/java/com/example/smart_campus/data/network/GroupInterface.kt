package com.example.smart_campus.data.network

import com.example.smart_campus.model.Group
import com.example.smart_campus.model.Note
import retrofit2.Response
import retrofit2.http.GET

interface GroupInterface {
    @GET("/api/group/user-group-list")
    suspend fun getGroup(): Response<Group>

    @GET("/api/group/all-group-app")
    suspend fun getGroupAll(): Response<Group>

    @GET("/api/push/my-push-log")
    suspend fun getNote(): Response<Note>
}