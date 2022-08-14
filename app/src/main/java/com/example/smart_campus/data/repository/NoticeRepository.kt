package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Notice
import com.example.smart_campus.model.NoticeItem

class NoticeRepository(){
    suspend fun retrofitSelectNotice(): Notice {
        val response =  NewworkObject.getRetrofitService.getNotice()
        Log.e("body", "NoteRepository: ${response.body()}", )

        val tmpData= Notice(listOf(
            NoticeItem("1","AI프로그래밍 경진대회(2회) 운영 안내","2022.08.11",""),
            NoticeItem("2","하계 계절학기 단기현장실습 제출서류 안내","2022.08.10",""),
            NoticeItem("3","하계방학 AI·SW분야 전문가 초청특강 운영","2022.08.09",""),
            NoticeItem("4"," 천안시와 함께하는 초등 SW 캠프 프로그램 공지","2022.08.06",""),
            NoticeItem("5","호서 SW몰입형캠프(로봇공학과) 운영","2022.08.05",""),
            NoticeItem("6","호서 SW몰입형캠프(하계방학) 장학금 지급 안내","2022.07.31",""),
            NoticeItem("7","Global PS 프로그램 운영 안내","2022.07.30",""),
            NoticeItem("8","호서 SW몰입형 캠프(계절학기) 수강 안내","2022.07.30",""),
            NoticeItem("9","2022 AI프로그래밍 경진대회(2회) 운영 안내","2022.08.11",""),
        ))
        return tmpData
//        return  if (response.isSuccessful) response.body() as Notice else Notice(ArrayList())
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