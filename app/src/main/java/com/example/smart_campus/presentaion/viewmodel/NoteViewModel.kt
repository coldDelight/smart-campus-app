package com.example.smart_campus.presentaion.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smart_campus.data.repository.NoteRepository
import com.example.smart_campus.model.Note
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository): ViewModel() {
    private val _retrofitNote = MutableLiveData<Note>()
    val retrofitNote: MutableLiveData<Note>
        get() = _retrofitNote
    init { // 초기화 시 서버에서 데이터를 받아온다.
        viewModelScope.launch {
            _retrofitNote.value = repository.retrofitSelectNote()
        }
    }
    class Factory(private val application : Application) : ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NoteViewModel(NoteRepository.getInstance(application)!!) as T
        }
    }

}