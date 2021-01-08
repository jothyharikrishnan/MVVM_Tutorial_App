package com.example.mvvm_tutorial_app.crud_app.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber):Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data")
    suspend fun deleteAll()

    @Query( "SELECT* FROM subscriber_data")
    fun getAllSubscribers():LiveData<List<Subscriber>>


}