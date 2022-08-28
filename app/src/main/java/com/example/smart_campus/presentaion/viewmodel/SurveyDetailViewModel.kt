package com.example.smart_campus.presentaion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.SurveyDetailRepository
import com.example.smart_campus.model.SurveyDetail
import kotlinx.coroutines.launch

class SurveyDetailViewModel(private val repository: SurveyDetailRepository,survey_id:Int): ViewModel() {
    private val _retrofitSurveyDetail = MutableLiveData<SurveyDetail>()
    val retrofitSurveyDetail: MutableLiveData<SurveyDetail>
        get() = _retrofitSurveyDetail
    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitSurveyDetail.value = repository.retrofitSurveyDetail(survey_id.toString())

        }
    }
    class Factory(survey_id:Int) : ViewModelProvider.Factory { // factory pattern
        private val survey_id: Int = survey_id
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SurveyDetailViewModel(SurveyDetailRepository.getInstance()!!,this.survey_id) as T
        }
    }

}