package com.example.smart_campus.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityGroupBinding
import com.example.smart_campus.presentaion.adapter.NoticeRecyclerAdapter
import com.example.smart_campus.presentaion.adapter.SurveyViewPagerAdapter
import com.example.smart_campus.presentaion.viewmodel.GroupHomeViewModel
import com.example.smart_campus.R
import com.example.smart_campus.SurveyDetailActivity


class GroupActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGroupBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy { ViewModelProvider(this,
        GroupHomeViewModel.Factory())[GroupHomeViewModel::class.java] }

    private lateinit var noticeAdapter: NoticeRecyclerAdapter
    private lateinit var surveyAdapter: SurveyViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val group_id = intent.getIntExtra("group_id",-1)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() //

        binding.groupBackBtn.setOnClickListener {
            finish()
        }

        noticeAdapter.onItemClick = {
            val intent = Intent(applicationContext, NoticeDetailActivity::class.java)
            intent.putExtra("group_id",it)
            startActivity(intent)
        }

        surveyAdapter.onItemClick = {
            val intent = Intent(applicationContext, SurveyDetailActivity::class.java)
            intent.putExtra("group_id",it)
            startActivity(intent)
        }
    }
    private fun setView(){
        noticeAdapter =  NoticeRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvGroupNotice.adapter = noticeAdapter // 리사이클러 뷰 연결

        surveyAdapter =  SurveyViewPagerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimens.xml 파일 안에 크기를 정의해두었다. (200dp)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimens.xml 파일이 없으면 생성해야함 (50dp)
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.pgGroupSurvey.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }
        binding.pgGroupSurvey.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        binding.pgGroupSurvey.adapter = surveyAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitNotice.observe(this) {
            viewModel.retrofitNotice.value?.let { it1 -> noticeAdapter.setData(it1) }
        }

        viewModel.retrofitSurvey.observe(this) {
            viewModel.retrofitSurvey.value?.let { it1 -> surveyAdapter.setData(it1) }
        }

    }
}