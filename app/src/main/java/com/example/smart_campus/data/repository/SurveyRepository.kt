package com.example.smart_campus.data.repository

import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Survey
import com.example.smart_campus.model.SurveyItem

class SurveyRepository {
    suspend fun retrofitSelectSurvey(group_id:String): Survey {
        val response =  NewworkObject.getRetrofitService.getSurvey(group_id)
        return  if (response.isSuccessful) response.body() as Survey else Survey(ArrayList())
    }
    companion object {
        private var instance: SurveyRepository? = null
        fun getInstance(): SurveyRepository? {
            if (instance == null) instance = SurveyRepository()
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}