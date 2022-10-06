package com.example.smart_campus.data.repository

import android.app.Application
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.*

class NoticeDetailRepository(application: Application) {
    suspend fun retrofitSelectNoticeDetail(notice_id: Int): NoticeDetail {
        val response = NewworkObject.getRetrofitService.getNoticeDetail(notice_id)
        return if (response.isSuccessful) response.body() as NoticeDetail else NoticeDetail(
            NoticeDetailItem("","",""))
    }

    companion object {
        private var instance: NoticeDetailRepository? = null
        fun getInstance(application: Application): NoticeDetailRepository? {
            if (instance == null) instance = NoticeDetailRepository(application)
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}