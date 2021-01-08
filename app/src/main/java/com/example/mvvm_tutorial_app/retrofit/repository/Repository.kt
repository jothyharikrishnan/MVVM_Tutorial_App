package com.example.mvvm_tutorial_app.retrofit.repository

import com.example.mvvm_tutorial_app.retrofit.Post
import com.example.mvvm_tutorial_app.retrofit.api.RetrofitInstance

class Repository {

    suspend fun  getPost():Post{
        return RetrofitInstance.api.getPost()
    }

}