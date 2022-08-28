package com.example.smart_campus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.example.smart_campus.databinding.ActivitySurveyDetailBinding
import com.example.smart_campus.presentaion.adapter.NoteRecylerAdapter
import com.example.smart_campus.presentaion.viewmodel.SurveyDetailViewModel
import kotlin.math.log

class SurveyDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySurveyDetailBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this,
        SurveyDetailViewModel.Factory(intent.getIntExtra("survey_id",-1)))[SurveyDetailViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        setView()
        setObserver()

        binding.surveyBackBtn.setOnClickListener {
            finish()
        }
    }

    private fun setView(){

    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitSurveyDetail.observe(this) {
//            viewModel.retrofitNote.value?.let { it1 -> retrofitAdapter.setData(it1) }
            viewModel.retrofitSurveyDetail.value?.let { it1 ->
                Log.e(
                    "ddd",
                    "setObserver: ${it1}",
                )
            }

//        }

        }
    }
}