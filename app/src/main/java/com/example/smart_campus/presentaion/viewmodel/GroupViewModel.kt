package com.example.smart_campus.presentaion.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.GroupRepository
import com.example.smart_campus.model.Group
import kotlinx.coroutines.launch

class GroupViewModel(private val repository: GroupRepository):ViewModel() {
    private val _retrofitGroup = MutableLiveData<Group>()
    val retrofitGroup: MutableLiveData<Group>
        get() = _retrofitGroup

    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitGroup.value = repository.retrofitSelectAllGroup()
        }
    }

    class Factory(private val application : Application) : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GroupViewModel(GroupRepository.getInstance(application)!!) as T
        }
    }

}