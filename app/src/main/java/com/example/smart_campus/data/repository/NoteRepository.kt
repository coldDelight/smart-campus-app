package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Note

class NoteRepository(application: Application){
    suspend fun retrofitSelectNote(): Note {
        val response =  NewworkObject.getRetrofitService.getNote()
        return  if (response.isSuccessful) response.body() as Note else Note(ArrayList())
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