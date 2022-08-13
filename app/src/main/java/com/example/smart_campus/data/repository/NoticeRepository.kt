package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Notice

class NoticeRepository(){
    suspend fun retrofitSelectNotice(): Notice {
        val response =  NewworkObject.getRetrofitService.getNotice()
        Log.e("body", "NoteRepository: ${response.body()}", )

        return  if (response.isSuccessful) response.body() as Notice else Notice(ArrayList())
    }
    companion object {
        private var instance: NoteRepository? = null
        fun getInstance(application : Application): NoteRepository? {
            if (instance == null) instance = NoteRepository(application)
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}