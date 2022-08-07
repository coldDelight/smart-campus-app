package com.example.smart_campus.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//class SignViewModel @Inject constructor(
//    private val service: RetrofitService
//) : ViewModel() {

//    private val _userInfo: MutableLiveData<UserInfo> = MutableLiveData()
//    val userInfo: LiveData<UserInfo>
//        get() = _userInfo

    // Retrofit을 이용하여 Repository에 저장된 데이터 가져오기
//    fun apiUserInfo() {
//        viewModelScope.launch {
//            val response = SignRepositoryImpl(service).getUserInfo(uid)
//                .awaitResponse()
//            if (response.isSuccessful) {
//
//                val data = response.body()
//
//                withContext(Main) {
//                    if (data != null) {
//                        Dlog.d("data :: ${Gson().toJson(data)}")
//                        _userInfo.value = data
//                    }
//                }
//            } else {
//                Dlog.d("failed :: ${response.message()}")
//            }
//        }
//    }
//}