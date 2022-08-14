package com.example.smart_campus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smart_campus.R
import com.example.smart_campus.databinding.ActivityChatbotBinding
import com.example.smart_campus.databinding.ActivityMyPageBinding

class ChatbotActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChatbotBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.chatbotBackBtn.setOnClickListener {
            finish()
        }

    }
}