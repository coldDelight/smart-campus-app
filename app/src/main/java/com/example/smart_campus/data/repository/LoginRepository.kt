package com.example.smart_campus.data.repository

import android.app.Application
import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Login
import com.example.smart_campus.model.LoginItem
import com.example.smart_campus.model.Note
import com.google.gson.JsonObject

class LoginRepository(){
    suspend fun retrofitLogin(user_id:String,pwd:String): Login {
        val jsonData: JsonObject = JsonObject().apply {
            addProperty("user_id", user_id)
            addProperty("pwd", pwd)
        }
        val response =  NewworkObject.getRetrofitService.postLogin(jsonData)


        return  if (response.isSuccessful) response.body() as Login else Login(LoginItem("","","","","",""))

    }
    companion object {
        private var instance: LoginRepository? = null
        fun getInstance(): LoginRepository? {
            if (instance == null) instance = LoginRepository()
            return instance
        }
    }
//    suspend fun retrofitInsertTodo(modelBoardComponent: ModelBoardComponent) : Response<JsonObject> {
//        return BoardObject.getRetrofitService.postBoard(modelBoardComponent.title, modelBoardComponent.contents)
//    }
}