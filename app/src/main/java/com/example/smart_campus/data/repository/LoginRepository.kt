package com.example.smart_campus.data.repository

import android.util.Log
import com.example.smart_campus.data.network.NewworkObject
import com.example.smart_campus.model.Error
import com.example.smart_campus.model.Login
import com.example.smart_campus.model.LoginItem
import com.google.gson.JsonObject

class LoginRepository(){
    suspend fun retrofitLogin(user_id:String,pwd:String): Login {
        val jsonData: JsonObject = JsonObject().apply {
            addProperty("user_id", user_id)
            addProperty("pwd", pwd)
        }
        val response =  NewworkObject.getRetrofitService.postLogin(jsonData)


        return  if (response.isSuccessful) response.body() as Login else Login(LoginItem("","","","","",""),Error("학번 혹은 비밀번호를 다시 확인하세요."))

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