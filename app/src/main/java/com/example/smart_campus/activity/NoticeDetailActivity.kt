package com.example.smart_campus.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityNoticeDetailBinding
import com.example.smart_campus.presentaion.viewmodel.NoteViewModel
import com.example.smart_campus.presentaion.viewmodel.NoticeDetailViewModel
import com.example.smart_campus.presentaion.viewmodel.SurveyDetailViewModel


class NoticeDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNoticeDetailBinding.inflate(layoutInflater) }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            NoticeDetailViewModel.Factory(application)
        )[NoticeDetailViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notice_id = intent.getIntExtra("notice_id", -1)
        Log.e("TAG", "onCreate: ${notice_id}", )

        viewModel.getNoticeDetail(notice_id)
//        val html = "<div class=\\\"board-content ck-content\\\"><p style=\\\"text-align: justify\\\"><br />[신청접수]</p><p style=\\\"text-align: justify\\\">구글폼링크:https://forms.gle/f32shtE7pkEm6uLc6</p><p style=\\\"text-align: justify\\\"><br /></p><p><img height=\\\"1080\\\" src=\\\"https://aisw.hoseo.ac.kr/api/image/imgdownload?hash=31ffb4dcd22f9bbdf64a80c27ed8c7b846680918b030771ff17fdeffd5e6abc7&idx=2200\\\" width=\\\"1080\\\"/></p><p style=\\\"text-align: justify\\\">[접수방법]</p><p style=\\\"text-align: justify\\\"> &nbsp;1) 구글폼링크:<a href=\\\"https://forms.gle/f32shtE7pkEm6uLc6\\\"><span style=\\\"color: rgb(0, 85, 255)\\\">https://forms.gle/f32shtE7pkEm6uLc6</span></a>) 접수신청</p><p style=\\\"text-align: justify\\\">2) AI Week Platform 홈페이지(<ahref=\\\"https://platform.hoseo.ac.kr/contest/info/view?idx=23\\\"><span style=\\\"color: rgb(0, 85, 255)\\\"><u>https://platform.hoseo.ac.kr/contest/info/view?idx=23</u></span></a><u>)</u>에 완성작(창업관련 PPT/WORD/HWP 중 택1, UCC 총 2가지)&nbsp;업로드</p></div"
//        binding.wb.loadData(html,"text/html; charset=utf-8", "UTF-8")
        setContentView(binding.root)
        binding.noticeBackBtn.setOnClickListener {
            finish()
        }
        setObserver()

    }

    private fun setObserver() {
        // 뷰모델 관찰
        viewModel.retrofitNoticeDetail.observe(this) {
            viewModel.retrofitNoticeDetail.value?.let { Log.e("TAG", "setObserver: $it") }
            val html = it.response.content
            binding.wb.loadData(html, "text/html; charset=utf-8", "UTF-8")
            binding.tvNoticeDetailTitle.text = it.response.title
            binding.tvNdDate.text = it.response.create_time.subSequence(0,10)

        }
    }
}