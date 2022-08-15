package com.example.smart_campus.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.smart_campus.databinding.ActivityChatbotBinding
import com.example.smart_campus.presentaion.adapter.ChatbotRecyclerAdapter
import com.example.smart_campus.presentaion.viewmodel.ChatbotViewModel

class ChatbotActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChatbotBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this,
        ChatbotViewModel.Factory())[ChatbotViewModel::class.java] }
    private lateinit var retrofitAdapter: ChatbotRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setView() // 리사이클러 뷰 연결
        setObserver() //

        binding.chatbotBackBtn.setOnClickListener {
            finish()
        }
        binding.button2.setOnClickListener {
            viewModel.askQuestion("소중대 번호 알려줘")
        }


    }
    private fun setView(){
        retrofitAdapter =  ChatbotRecyclerAdapter().apply {
            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
        }
        binding.rvCahtbot.adapter = retrofitAdapter // 리사이클러 뷰 연결
    }
    private fun setObserver() {
        viewModel.retrofitChatbot.observe(this) {
            if (viewModel.retrofitChatbot.value?.toMutableList()?.isNotEmpty() == true){
                viewModel.retrofitChatbot.value?.toMutableList()?.last().let { it1 ->
                    if (it1 != null) {
                        retrofitAdapter.setData(it1)
                    }
                }
            }

        }
        // 뷰모델 관찰


    }
}