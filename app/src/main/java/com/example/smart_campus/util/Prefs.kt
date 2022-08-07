package com.example.smart_campus.util

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {
    private val prefNm="JWT_TOKKEN"
    private val prefs=context.getSharedPreferences(prefNm,MODE_PRIVATE)

    var token:String?
        get() = prefs.getString("token",null)
        set(value){
            prefs.edit().putString("token",value).apply()
        }

}