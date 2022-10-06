package com.example.smart_campus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityGroupSearchBinding
import com.example.smart_campus.presentaion.adapter.GroupAllRecyclerAdapter
import com.example.smart_campus.presentaion.viewmodel.GroupSearchViewModel

class GroupSearchActivity : AppCompatActivity() {


    private val binding by lazy { ActivityGroupSearchBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,
        GroupSearchViewModel.Factory(application))[GroupSearchViewModel::class.java] }
    private lateinit var retrofitAdapter: GroupAllRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.groupshBackBtn.setOnClickListener {
            finish()
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() // 뷰모델을 관찰합니다.

        retrofitAdapter.onAddClick = {
            viewModel.addGroup(it,this)
        }

    }
    private fun setView(){
        retrofitAdapter =  GroupAllRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvAllGroup.adapter = retrofitAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitGroup.observe(this) {
            viewModel.retrofitGroup.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}