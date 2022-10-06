package com.example.smart_campus.presentaion.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.NoticeDetailRepository
import com.example.smart_campus.model.NoticeDetail
import kotlinx.coroutines.launch

class NoticeDetailViewModel(private val repository: NoticeDetailRepository): ViewModel() {
    private val _retrofitNoticeDetail = MutableLiveData<NoticeDetail>()
    val retrofitNoticeDetail: MutableLiveData<NoticeDetail>
        get() = _retrofitNoticeDetail

    fun getNoticeDetail(notice_id:Int){
        viewModelScope.launch {
            _retrofitNoticeDetail.value = repository.retrofitSelectNoticeDetail(notice_id)
        }
    }


    class Factory(private val application : Application) : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NoticeDetailViewModel(NoticeDetailRepository.getInstance(application)!!) as T
        }
    }

}