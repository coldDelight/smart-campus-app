package com.example.smart_campus.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.smart_campus.R
import com.example.smart_campus.SmartCampusApp
import com.example.smart_campus.databinding.ActivityMyPageBinding
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding

class MyPageActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMyPageBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.logoutBtn.setOnClickListener {
            SmartCampusApp.prefs.token="NO_TOKEN"
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)

        }
        binding.myBackBtn.setOnClickListener {
            finish()
        }
    }
}