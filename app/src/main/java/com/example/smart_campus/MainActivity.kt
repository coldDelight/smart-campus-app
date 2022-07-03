package com.example.smart_campus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val loginBtn = findViewById<Button>(R.id.button_login_login)
        loginBtn.setOnClickListener(){
            val intent = Intent(applicationContext, HomePage::class.java)
            startActivity(intent)

        }
    }
}