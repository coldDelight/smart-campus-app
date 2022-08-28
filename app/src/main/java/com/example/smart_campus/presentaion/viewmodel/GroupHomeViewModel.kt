package com.example.smart_campus.presentaion.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.NoticeRepository
import com.example.smart_campus.data.repository.SurveyRepository
import com.example.smart_campus.model.Notice
import com.example.smart_campus.model.Survey
import kotlinx.coroutines.launch

class GroupHomeViewModel(private val noteRepository: NoticeRepository,private val surveyRepository: SurveyRepository,group_id:Int): ViewModel() {
    private val _retrofitNotice = MutableLiveData<Notice>()
    val retrofitNotice: MutableLiveData<Notice>
        get() = _retrofitNotice

    private val _retrofitSurvey = MutableLiveData<Survey>()
    val retrofitSurvey: MutableLiveData<Survey>
        get() = _retrofitSurvey


    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitNotice.value = noteRepository.retrofitSelectNotice(group_id.toString())
            _retrofitSurvey.value = surveyRepository.retrofitSelectSurvey(group_id.toString())
        }
    }
    class Factory(group_id: Int) : ViewModelProvider.Factory { // factory pattern
        private val group_id: Int = group_id
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GroupHomeViewModel(NoticeRepository.getInstance()!!,SurveyRepository.getInstance()!!,this.group_id) as T
        }
    }

}