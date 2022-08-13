package com.example.smart_campus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.R
import com.example.smart_campus.databinding.ActivityGroupBinding
import com.example.smart_campus.presentaion.adapter.NoteRecylerAdapter
import com.example.smart_campus.presentaion.adapter.NoticeRecyclerAdapter
import com.example.smart_campus.presentaion.viewmodel.NoticeViewModel

class GroupActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGroupBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,
        NoticeViewModel.Factory(application))[NoticeViewModel::class.java] }
    private lateinit var retrofitAdapter: NoticeRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() //

        binding.groupBackBtn.setOnClickListener {
            finish()
        }

    }


    private fun setView(){
        retrofitAdapter =  NoticeRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvGroupNotice.adapter = retrofitAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitNote.observe(this) {
            viewModel.retrofitNote.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}