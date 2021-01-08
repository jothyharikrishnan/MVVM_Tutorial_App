package com.example.mvvm_tutorial_app.shopping_list_activity.data.repository

import com.example.mvvm_tutorial_app.shopping_list_activity.ShoppingItem
import com.example.mvvm_tutorial_app.shopping_list_activity.data.db.ShoppingDatabase

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
  suspend fun upsert(item:ShoppingItem)=db.getShoppingDao().update(item)
    suspend fun delete(item:ShoppingItem)=db.getShoppingDao().delete(item)

     fun getAllShoppingItem()=db.getShoppingDao().getAllShoppingItem()

}