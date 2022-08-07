package com.example.smart_campus.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smart_campus.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository //레포지토리
):ViewModel(){

}