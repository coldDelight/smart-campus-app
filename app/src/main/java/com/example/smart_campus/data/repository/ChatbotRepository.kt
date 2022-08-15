package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Chatbot
import com.example.smart_campus.model.ChatbotStart
import com.example.smart_campus.model.Note
import com.google.gson.JsonObject

class ChatbotRepository(){
    suspend fun retrofitSelectChatbotStart(): ChatbotStart {
        val response =  NewworkObject.getRetrofitServiceChat.getChatStart()

        return  if (response.isSuccessful) response.body() as ChatbotStart else ChatbotStart("")
    }

    suspend fun retrofitSelectChatbot(query:String): Chatbot {
        val jsonData: JsonObject = JsonObject().apply {
            addProperty("query", query)
        }
        val response =  NewworkObject.getRetrofitServiceChat.postCahtbot(jsonData)
        return  if (response.isSuccessful) response.body() as Chatbot else Chatbot("")
    }

    companion object {
        private var instance: ChatbotRepository? = null
        fun getInstance(): ChatbotRepository? {
            if (instance == null) instance = ChatbotRepository()
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}