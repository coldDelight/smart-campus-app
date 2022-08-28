package com.example.smart_campus.data.repository

import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.SurveyDetail

class SurveyDetailRepository {
    suspend fun retrofitSurveyDetail(surveyId: String): SurveyDetail {
        val response = NewworkObject.getRetrofitService.getSurveyDetail(surveyId)
        return if (response.isSuccessful) response.body() as SurveyDetail else SurveyDetail(
            ArrayList()
        )
    }

    companion object {
        private var instance: SurveyDetailRepository? = null
        fun getInstance(): SurveyDetailRepository? {
            if (instance == null) instance = SurveyDetailRepository()
            return instance
        }
    }
}
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }