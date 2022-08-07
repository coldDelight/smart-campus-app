package com.example.smart_campus.data.repository

import com.example.smart_campus.data.remote.MyApi
import com.example.smart_campus.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api:MyApi //di 모듈에서 어떻게 만드는지 알려줌
) :MyRepository{


    override suspend fun doNetWorkCall() {
    }

}