package com.example.mvvm_tutorial_app.crud_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.crud_app.db.Subscriber
import com.example.mvvm_tutorial_app.crud_app.db.SubscriberDatabase
import com.example.mvvm_tutorial_app.crud_app.db.SubscriberRepository
import com.example.mvvm_tutorial_app.databinding.ActivityCrudMainBinding

class CrudMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrudMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_crud_main)

        val dao=SubscriberDatabase.getInstance(application).subscriberDAO
        val repository=SubscriberRepository(dao)
        val factory=SubscriberViewModelFactory(repository)
        subscriberViewModel=ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)
        binding.myViewModel=subscriberViewModel
        binding.lifecycleOwner=this
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.crudRecycler.layoutManager=LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun displaySubscriberList(){
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            binding.crudRecycler.adapter=MyRecyclerViewAdapter(it,{selectedItem:Subscriber->listItemClicked(selectedItem)})
        })
    }

    private fun listItemClicked(subscriber: Subscriber){
        Toast.makeText(this,"Selected Name Is ${subscriber.name}",Toast.LENGTH_LONG).show()
    }
}