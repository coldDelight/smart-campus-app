package com.example.smart_campus

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
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() // 뷰모델을 관찰합니다.
    }
    private fun setView(){
        retrofitAdapter =  GroupAllRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.homeActivityGrouprv.adapter = retrofitAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitGroup.observe(this) {
            viewModel.retrofitGroup.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}