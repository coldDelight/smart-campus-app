package com.example.smart_campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val logoutBtn = findViewById<Button>(R.id.logout_btn)
        logoutBtn.setOnClickListener {
            SmartCampusApp.prefs.token="NO_TOKEN"
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}