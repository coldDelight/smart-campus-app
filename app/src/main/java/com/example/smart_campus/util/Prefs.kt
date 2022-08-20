package com.example.smart_campus.util

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {
    private val prefNm="JWT_TOKKEN"
    private val prefs=context.getSharedPreferences(prefNm,MODE_PRIVATE)

    //스트링 리소스로 빼기
    var token:String?
        get() = prefs.getString("token","NoTOKEN")
        set(value){
            prefs.edit().putString("token",value).apply()
        }

}