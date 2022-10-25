package com.example.smart_campus.data.repository

import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Answer
import com.example.smart_campus.model.SurRes
import com.example.smart_campus.model.SurveyAnswer
import com.example.smart_campus.model.SurveyDetail
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import java.lang.reflect.Modifier


class SurveyDetailRepository {
    suspend fun retrofitSurveyDetail(surveyId: String): SurveyDetail {
        val response = NewworkObject.getRetrofitService.getSurveyDetail(surveyId)
        return if (response.isSuccessful) response.body() as SurveyDetail else SurveyDetail(
            ArrayList()
        )
    }

    suspend fun retrofitSurveyPost(answer: MutableMap<Int,String>,surveyId: String): SurveyAnswer {
        val question_data = arrayListOf<Answer>()


        var sendData = arrayListOf<Answer>()
        for(i:Int in answer.keys){
            answer[i]?.let { it1 -> Answer(i, it1) }?.let { it2 -> sendData.add(it2) }
        }
        val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT)
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()
        val res = SurRes(
            surveyId.toInt(),
            sendData,
        )

        val data =gson.toJsonTree(res)
        val jsonData = data.asJsonObject

        val response = NewworkObject.getRetrofitService.postSurvey(jsonData)
        return if (response.isSuccessful) response.body() as SurveyAnswer else SurveyAnswer(
            ""
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