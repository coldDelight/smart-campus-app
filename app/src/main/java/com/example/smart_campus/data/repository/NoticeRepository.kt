package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Notice
import com.example.smart_campus.model.NoticeItem

class NoticeRepository(){
    suspend fun retrofitSelectNotice(group_id:String): Notice {
        val response =  NewworkObject.getRetrofitService.getNotice(group_id)
        return  if (response.isSuccessful) response.body() as Notice else Notice(ArrayList())
    }
    companion object {
        private var instance: NoticeRepository? = null
        fun getInstance(): NoticeRepository? {
            if (instance == null) instance = NoticeRepository()
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}