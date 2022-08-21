package com.example.smart_campus.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.smart_campus.R
import com.example.smart_campus.databinding.ActivityHomePageBinding
import com.example.smart_campus.presentaion.SwipeHelper
import com.example.smart_campus.presentaion.adapter.GroupRecyclerAdapter
import com.example.smart_campus.presentaion.viewmodel.GroupViewModel

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomePageBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,GroupViewModel.Factory(application))[GroupViewModel::class.java] }
    private lateinit var retrofitAdapter: GroupRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() // 뷰모델을 관찰합니다.
        val chatBtn = findViewById<ImageButton>(R.id.chatBtn)
        val groupSearchBtn = findViewById<ImageButton>(R.id.btn_group_search)
        val myPageBtn = findViewById<ImageButton>(R.id.home_mypage_btn)
        val noteBtn = findViewById<ImageButton>(R.id.home_note_btn)

        chatBtn.setOnClickListener(){
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }

        groupSearchBtn.setOnClickListener(){
            val intent = Intent(applicationContext, GroupSearchActivity::class.java)
            startActivity(intent)
        }
        myPageBtn.setOnClickListener(){
            val intent = Intent(applicationContext, MyPageActivity::class.java)
            startActivity(intent)
        }
        noteBtn.setOnClickListener(){
            val intent = Intent(applicationContext, NoteActivity::class.java)
            startActivity(intent)
        }

        retrofitAdapter.onItemClick = {
            val intent = Intent(applicationContext, GroupActivity::class.java)
            intent.putExtra("group_id",it)
            startActivity(intent)
        }

        binding.btnGroupDel.setOnClickListener {
            retrofitAdapter.isDelSate = !retrofitAdapter.isDelSate
            retrofitAdapter.notifyDataSetChanged()

        }

    }

    override fun onStart() {
        super.onStart()
        viewModel.reLoad()
    }

    private fun setView(){
        retrofitAdapter =  GroupRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvAllGroup.adapter = retrofitAdapter // 리사이클러 뷰 연결
        val swipeHelper = SwipeHelper(retrofitAdapter).apply {
            setClamp((resources.displayMetrics.widthPixels.toFloat() / 4))
        }
        ItemTouchHelper(swipeHelper).attachToRecyclerView(binding.rvAllGroup)
        binding.rvAllGroup.setOnTouchListener { _, _ ->
            swipeHelper.removePreviousClamp(binding.rvAllGroup)
            false
        }


    }

    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitGroup.observe(this) {
            viewModel.retrofitGroup.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}