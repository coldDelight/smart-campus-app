package com.example.smart_campus.presentaion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.ChatbotRepository
import com.example.smart_campus.model.ChatbotMessage
import kotlinx.coroutines.launch

class ChatbotViewModel(private val repository: ChatbotRepository): ViewModel() {
    private var _retrofitChatbot:MutableLiveData<List<ChatbotMessage>> =  MutableLiveData(listOf())
    val retrofitChatbot: MutableLiveData<List<ChatbotMessage>>
        get() = _retrofitChatbot

    private var tmpList:ArrayList<ChatbotMessage> = ArrayList()

    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            val resStart = repository.retrofitSelectChatbotStart().message
            addList(resStart,false)
        }
    }

    fun askQuestion(query:String){
        addList(query,true)
        viewModelScope.launch {
            val resMes = repository.retrofitSelectChatbot(query).Answer
            addList(resMes,false)
        }
    }

    private fun addList(item:String,isUserSend:Boolean){
        tmpList.add(ChatbotMessage(item,isUserSend))
        _retrofitChatbot.value = tmpList
    }

    class Factory() : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ChatbotViewModel(ChatbotRepository.getInstance()!!) as T
        }
    }

}