package com.example.smart_campus

import android.app.Application
import android.content.Intent
import com.example.smart_campus.util.Prefs

class SmartCampusApp :Application(){
    companion object{
        lateinit var prefs:Prefs
    }
    override fun onCreate() {
        prefs=Prefs(applicationContext)
        super.onCreate()
    }

}