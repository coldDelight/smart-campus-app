package com.example.smart_campus.presentaion.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.GroupRepository
import com.example.smart_campus.model.Group
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class GroupSearchViewModel(private val repository: GroupRepository):ViewModel() {
    private val _retrofitGroup = MutableLiveData<Group>()
    val retrofitGroup: MutableLiveData<Group>
        get() = _retrofitGroup

    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitGroup.value = repository.retrofitSelectAllGroup("All")
        }
    }

    fun addGroup(group_id:String,context: Context){
        viewModelScope.launch {
            val data = repository.retrofitAddGroup(group_id)
            //Todo context넘기는거 수정!
            if(data.response==""){
                Toast.makeText(context,"이미 추가한 그룹입니다.",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"그룹을 추가했습니다.",Toast.LENGTH_SHORT).show()

            }
            repository.retrofitAddGroup(group_id)
        }
    }

    class Factory(private val application : Application) : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GroupSearchViewModel(GroupRepository.getInstance(application)!!) as T
        }
    }

}