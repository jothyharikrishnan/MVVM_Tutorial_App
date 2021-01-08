package com.example.mvvm_tutorial_app.retrofit

import com.google.gson.annotations.SerializedName

data class Post(@SerializedName("userId")
    val myUserId:Int,
                val id:Int,
                val title:String,
                val body:String) {

}