package com.example.mvvm_tutorial_app.room_database.data

import androidx.lifecycle.LiveData
import com.example.mvvm_tutorial_app.room_database.model.User

class UserRepository(private val userDao: UserDao) {

    val  readAllData:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}