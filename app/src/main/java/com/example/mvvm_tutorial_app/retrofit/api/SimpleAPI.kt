package com.example.mvvm_tutorial_app.retrofit.api

import com.example.mvvm_tutorial_app.retrofit.Post
import retrofit2.http.GET

interface SimpleAPI {

    @GET("posts/1")
    suspend fun  getPost():Post
}