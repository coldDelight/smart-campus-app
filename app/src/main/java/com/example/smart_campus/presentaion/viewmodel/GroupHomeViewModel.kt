package com.example.smart_campus.presentaion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.NoticeRepository
import com.example.smart_campus.data.repository.SurveyRepository
import com.example.smart_campus.model.Notice
import com.example.smart_campus.model.Survey
import kotlinx.coroutines.launch

class GroupHomeViewModel(private val noteRepository: NoticeRepository,private val surveyRepository: SurveyRepository): ViewModel() {
    private val _retrofitNotice = MutableLiveData<Notice>()
    val retrofitNotice: MutableLiveData<Notice>
        get() = _retrofitNotice

    private val _retrofitSurvey = MutableLiveData<Survey>()
    val retrofitSurvey: MutableLiveData<Survey>
        get() = _retrofitSurvey


    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitNotice.value = noteRepository.retrofitSelectNotice()
            _retrofitSurvey.value = surveyRepository.retrofitSelectSurvey()
        }
    }
    class Factory() : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GroupHomeViewModel(NoticeRepository.getInstance()!!,SurveyRepository.getInstance()!!) as T
        }
    }

}