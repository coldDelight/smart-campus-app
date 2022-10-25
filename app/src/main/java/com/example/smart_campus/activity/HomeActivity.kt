package com.example.smart_campus.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import com.auth0.android.jwt.JWT
import com.example.smart_campus.SmartCampusApp
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
        val jwt = SmartCampusApp.prefs.token?.let { JWT(it) }
        val uid = jwt?.getClaim("STUDENT_ID")?.asString()
        val name = jwt?.getClaim("NM")?.asString()
        val dept = jwt?.getClaim("DEPT_NM")?.asString()

        setView() // 리사이클러 뷰 연결
        setObserver() // 뷰모델을 관찰합니다.
        setButton()

        binding.tvHomeName.text = name
        binding.tvHomeDept.text = dept
        binding.tvHomeId.text = uid

        retrofitAdapter.onItemClick = {
            val intent = Intent(applicationContext, GroupActivity::class.java)
            intent.putExtra("group_id",it.id.toInt())
            intent.putExtra("group_name",it.name)
            intent.putExtra("group_intro",it.intro)
            startActivity(intent)
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


    private fun setButton(){
        binding.btnGroupDel.setOnClickListener {
            retrofitAdapter.isDelSate = !retrofitAdapter.isDelSate
            retrofitAdapter.notifyDataSetChanged()

        }
        binding.chatBtn.setOnClickListener(){
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }

        binding.btnGroupSearch.setOnClickListener(){
            val intent = Intent(applicationContext, GroupSearchActivity::class.java)
            startActivity(intent)
        }
        binding.homeMypageBtn.setOnClickListener(){
            val intent = Intent(applicationContext, MyPageActivity::class.java)
            startActivity(intent)
        }
        binding.homeNoteBtn.setOnClickListener(){
            val intent = Intent(applicationContext, NoteActivity::class.java)
            startActivity(intent)
        }


    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitGroup.observe(this) {
            if (it.response.isEmpty()){
                binding.tvIsgroupadded.visibility = View.VISIBLE
            }else{
                binding.tvIsgroupadded.visibility = View.INVISIBLE

            }
            viewModel.retrofitGroup.value?.let { it1 -> retrofitAdapter.setData(it1) }
        }

    }
}