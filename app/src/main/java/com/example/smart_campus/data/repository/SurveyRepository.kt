package com.example.smart_campus.data.repository

import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Survey
import com.example.smart_campus.model.SurveyItem

class SurveyRepository {
    suspend fun retrofitSelectSurvey(): Survey {
        val response =  NewworkObject.getRetrofitService.getSurvey()
        Log.e("body", "NoteRepository: ${response.body()}", )
        val tmpData= Survey(listOf(
            SurveyItem("1","AI프로그래밍 경진대회(2회) 운영 안내","2022.08.11","0"),
            SurveyItem("2","하계 계절학기 단기현장실습 제출서류 안내","2022.08.10","0"),
            SurveyItem("3","하계방학 AI·SW분야 전문가 초청특강 운영","2022.08.09","0"),
            SurveyItem("4"," 천안시와 함께하는 초등 SW 캠프 프로그램 공지","2022.08.06","0"),
            SurveyItem("5","호서 SW몰입형캠프(로봇공학과) 운영","2022.08.05","0"),
            SurveyItem("6","호서 SW몰입형캠프(하계방학) 장학금 지급 안내","2022.07.31","0"),
            SurveyItem("7","Global PS 프로그램 운영 안내","2022.07.30","0"),
            SurveyItem("8","호서 SW몰입형 캠프(계절학기) 수강 안내","2022.07.30","0"),
            SurveyItem("9","2022 AI프로그래밍 경진대회(2회) 운영 안내","2022.08.11","0"),
        ))
        return tmpData
//        return  if (response.isSuccessful) response.body() as Survey else Survey(ArrayList())
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