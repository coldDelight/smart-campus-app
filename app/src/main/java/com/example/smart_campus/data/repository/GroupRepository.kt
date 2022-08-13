package com.example.smart_campus.data.repository

import android.app.Application
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Group

class GroupRepository(application: Application){
    suspend fun retrofitSelectAllGroup(type:String): Group {
        val response = if(type=="All")NewworkObject.getRetrofitService.getGroupAll() else NewworkObject.getRetrofitService.getGroup()
        return  if (response.isSuccessful) response.body() as Group  else Group(ArrayList())
    }
    companion object {
        private var instance: GroupRepository? = null
        fun getInstance(application : Application): GroupRepository? {
            if (instance == null) instance = GroupRepository(application)
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}