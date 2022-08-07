package com.example.smart_campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val chatBtn = findViewById<ImageButton>(R.id.chatBtn)
        val groupSearchBtn = findViewById<ImageButton>(R.id.home_groupsearch_btn)
        val myPageBtn = findViewById<ImageButton>(R.id.home_mypage_btn)
        val noteBtn = findViewById<ImageButton>(R.id.home_note_btn)

        chatBtn.setOnClickListener(){
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }

        groupSearchBtn.setOnClickListener(){
            val intent = Intent(applicationContext, GroupSearchActivity::class.java)
            startActivity(intent)
        }
        myPageBtn.setOnClickListener(){
            val intent = Intent(applicationContext, MyPageActivity::class.java)
            startActivity(intent)
        }
        noteBtn.setOnClickListener(){
            val intent = Intent(applicationContext, NoteActivity::class.java)
            startActivity(intent)
        }


    }
}