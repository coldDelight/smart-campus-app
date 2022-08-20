package com.example.smart_campus.presentaion.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.LoginRepository
import com.example.smart_campus.model.Login
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository): ViewModel() {
    private val _retrofitLogin = MutableLiveData<Login>()
    val retrofitLogin: MutableLiveData<Login>
        get() = _retrofitLogin

    fun Login(user_id:String,pwd:String){
        viewModelScope.launch {
            _retrofitLogin.value = repository.retrofitLogin(user_id,pwd)
        }
    }


    class Factory() : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(LoginRepository.getInstance()!!) as T
        }
    }

}