package com.example.smart_campus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.example.smart_campus.databinding.ActivitySurveyDetailBinding
import com.example.smart_campus.model.Answer
import com.example.smart_campus.presentaion.adapter.NoteRecylerAdapter
import com.example.smart_campus.presentaion.adapter.SurveyDetailAdapter
import com.example.smart_campus.presentaion.viewmodel.SurveyDetailViewModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import kotlin.math.log

class SurveyDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySurveyDetailBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this,
        SurveyDetailViewModel.Factory(intent.getIntExtra("survey_id",-1)))[SurveyDetailViewModel::class.java] }

    private lateinit var retrofitAdapter: SurveyDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        setView()
        setObserver()

        retrofitAdapter.hideKey = {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        }
        binding.surveyBackBtn.setOnClickListener {
            finish()
        }
        binding.btnSubmit.setOnClickListener {
            if(retrofitAdapter.answer.size < (viewModel.retrofitSurveyDetail.value?.response?.size
                    ?: 0)
            ){
                Toast.makeText(this,"답하지 않은 질문이 있습니다",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"설문 작성이 완료되었습니다.",Toast.LENGTH_SHORT).show()
                val data = retrofitAdapter.answer

//                Log.e("TAG", "onCreate: ${sendData}", )
                viewModel.postSurvey(retrofitAdapter.answer,intent.getIntExtra("survey_id",-1).toString())
                finish()
            }
        }
    }

    private fun setView(){
        retrofitAdapter =  SurveyDetailAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvSurveyDetail.adapter = retrofitAdapter

    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitSurveyDetail.observe(this) {
            Log.e("TAG", "setObserver: $it", )
            retrofitAdapter.setData(it)
//            viewModel.retrofitSurveyDetail.value?.let { it1 -> retrofitAdapter.setData(it1) }
//            viewModel.retrofitSurveyDetail.value?.let { it1 ->
//                Log.e(
//                    "ddd",
//                    "setObserver: ${it1.response}",
//                )
//            }
//
//        }
//
        }
    }
}