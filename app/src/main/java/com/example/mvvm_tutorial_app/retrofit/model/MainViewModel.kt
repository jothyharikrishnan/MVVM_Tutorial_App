package com.example.mvvm_tutorial_app.retrofit.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tutorial_app.retrofit.Post
import com.example.mvvm_tutorial_app.retrofit.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {
    private val myResponse:MutableLiveData<Post> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response=repository.getPost()
            myResponse.value=response
        }
    }
}