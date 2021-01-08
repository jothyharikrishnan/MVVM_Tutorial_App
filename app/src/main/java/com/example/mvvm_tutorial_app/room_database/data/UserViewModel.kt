package com.example.mvvm_tutorial_app.room_database.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tutorial_app.room_database.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
     val readable:LiveData<List<User>>
    private val repository:UserRepository

    init {
        val userDao=UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(userDao)
        readable=repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user:User){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateUser(user)
        }
    }
}