package com.example.smart_campus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.example.smart_campus.databinding.ActivitySurveyDetailBinding

class SurveyDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySurveyDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.surveyBackBtn.setOnClickListener {
            finish()
        }
    }
}