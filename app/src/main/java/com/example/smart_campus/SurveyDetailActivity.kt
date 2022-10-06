package com.example.smart_campus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.example.smart_campus.databinding.ActivitySurveyDetailBinding
import com.example.smart_campus.presentaion.adapter.NoteRecylerAdapter
import com.example.smart_campus.presentaion.adapter.SurveyDetailAdapter
import com.example.smart_campus.presentaion.viewmodel.SurveyDetailViewModel
import kotlin.math.log

class SurveyDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySurveyDetailBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this,
        SurveyDetailViewModel.Factory(intent.getIntExtra("survey_id",-1)))[SurveyDetailViewModel::class.java] }

//    private lateinit var retrofitAdapter: SurveyDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        setView()
        setObserver()

        binding.surveyBackBtn.setOnClickListener {
            finish()
        }
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this,"설문 작성이 완료되었습니다.",Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setView(){
//        retrofitAdapter =  SurveyDetailAdapter().apply {
//            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
//        }
//        binding.rvSurveyDetail.adapter = retrofitAdapter

    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitSurveyDetail.observe(this) {
//            viewModel.retrofitSurveyDetail.value?.let { it1 -> retrofitAdapter.setData(it1) }
//            viewModel.retrofitSurveyDetail.value?.let { it1 ->
//                Log.e(
//                    "ddd",
//                    "setObserver: ${it1.response}",
//                )
//            }

//        }

        }
    }
}