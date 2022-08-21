package com.example.smart_campus.data.repository

import android.app.Application
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Group
import com.example.smart_campus.model.GroupEdit
import com.google.gson.JsonObject

class GroupRepository(application: Application){
    suspend fun retrofitSelectAllGroup(type:String): Group {
        val response = if(type=="All"){
            NewworkObject.getRetrofitService.getGroupAll()
        } else NewworkObject.getRetrofitService.getGroup()
        return  if (response.isSuccessful) response.body() as Group else Group(ArrayList())
    }


    suspend fun retrofitAddGroup(group_id:String): GroupEdit {
        val jsonData: JsonObject = JsonObject().apply {
            addProperty("group_id", group_id)
        }
        val response = NewworkObject.getRetrofitService.addGroup(jsonData)

        return  if (response.isSuccessful) response.body() as GroupEdit else GroupEdit("")
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