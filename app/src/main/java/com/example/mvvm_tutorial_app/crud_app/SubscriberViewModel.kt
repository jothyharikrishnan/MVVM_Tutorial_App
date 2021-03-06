package com.example.mvvm_tutorial_app.crud_app

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tutorial_app.crud_app.db.Subscriber
import com.example.mvvm_tutorial_app.crud_app.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository):ViewModel(),Observable {

    val subscribers=repository.subscribers
    val thisContext:Context?=null


    @Bindable
    val inputName=MutableLiveData<String>()

    @Bindable
    val inputEmail=MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText=MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText=MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value="Save"
        clearAllOrDeleteButtonText.value="Clear ALL"

    }

    fun saveOrUpdate(){
        val name=inputName.value!!
        val email=inputEmail.value!!
       /* if (name.isEmpty() && email.isEmpty())
            Toast.makeText(thisContext,"Please Fill The Fields",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(thisContext,"Successfully Updated",Toast.LENGTH_LONG).show()*/
        insert(Subscriber(0,name,email))
        inputName.value=null
        inputEmail.value=null
    }

    fun clearAllOrDelete(){

        clearAll()

    }

    fun insert(subscriber: Subscriber){

        viewModelScope.launch {
            repository.insert(subscriber)
        }
    }

    fun update(subscriber: Subscriber){

        viewModelScope.launch {
            repository.update(subscriber)
        }
    }

    fun delete(subscriber: Subscriber){

        viewModelScope.launch {
            repository.delete(subscriber)
        }
    }
    fun clearAll(){

        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}