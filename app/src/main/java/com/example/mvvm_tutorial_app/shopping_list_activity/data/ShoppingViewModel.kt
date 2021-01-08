package com.example.mvvm_tutorial_app.shopping_list_activity.data

import androidx.lifecycle.ViewModel
import com.example.mvvm_tutorial_app.shopping_list_activity.ShoppingItem
import com.example.mvvm_tutorial_app.shopping_list_activity.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) :ViewModel(){
    fun upsert(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem()=repository.getAllShoppingItem()
}