package com.example.smart_campus.data.network

import com.example.smart_campus.model.Group
import retrofit2.Response
import retrofit2.http.GET

interface GroupInterface {
    @GET("/api/group/user-group-list")
    suspend fun getGroup(): Response<Group>
}