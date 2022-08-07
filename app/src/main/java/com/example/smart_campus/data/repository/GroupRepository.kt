package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.GroupObject
import com.example.smart_campus.model.Group
import com.example.smart_campus.model.GroupItem

class GroupRepository(application: Application){
    suspend fun retrofitSelectAllGroup(): Group {
        val response = GroupObject.getRetrofitService.getGroup()
        Log.e("gggg", "retrofitSelectAllGroup: ${response.body()}", )
        Log.e("gggg", "retrofitSelectAllGroup: ${response}", )
//        return if (response.isSuccessful) response.body() as Group else Group("false",[]as GroupItem,"true")
//        return  if (response.isSuccessful) response.body() as Group  else Group("", listOf(GroupItem("","","")),"")
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