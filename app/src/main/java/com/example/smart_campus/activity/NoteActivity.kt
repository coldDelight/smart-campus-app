package com.example.smart_campus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityNoteBinding
import com.example.smart_campus.presentaion.adapter.NoteRecylerAdapter
import com.example.smart_campus.presentaion.viewmodel.NoteViewModel

class NoteActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,
        NoteViewModel.Factory(application))[NoteViewModel::class.java] }
    private lateinit var retrofitAdapter: NoteRecylerAdapter


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
        retrofitAdapter =  NoteRecylerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.homeActivityNoterv.adapter = retrofitAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitNote.observe(this) {
            if (it.response.isEmpty()){
                binding.tvNote.visibility = View.VISIBLE
            }else{
                binding.tvNote.visibility = View.INVISIBLE

            }

            viewModel.retrofitNote.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}