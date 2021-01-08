package com.example.mvvm_tutorial_app.shopping_list_activity.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm_tutorial_app.shopping_list_activity.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: ShoppingItem)

    @Delete
   suspend fun delete(item: ShoppingItem)

    @Query("SELECT* FROM shopping_items")
    fun getAllShoppingItem():LiveData<List<ShoppingItem>>
}