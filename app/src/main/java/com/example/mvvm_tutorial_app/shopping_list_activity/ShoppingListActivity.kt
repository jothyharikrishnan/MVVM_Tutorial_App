package com.example.mvvm_tutorial_app.shopping_list_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.shopping_list_activity.adapter.ShoppingItemAdapter
import com.example.mvvm_tutorial_app.shopping_list_activity.data.ShoppingViewModel
import com.example.mvvm_tutorial_app.shopping_list_activity.data.ShoppingViewModelFactory
import com.example.mvvm_tutorial_app.shopping_list_activity.data.db.ShoppingDatabase
import com.example.mvvm_tutorial_app.shopping_list_activity.data.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        val database=ShoppingDatabase(this)
        val repository=ShoppingRepository(database)
        val factory=ShoppingViewModelFactory(repository)

        val viewModel=ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter=ShoppingItemAdapter(listOf(),viewModel)

        shoppingRecyclerList.layoutManager=LinearLayoutManager(this)
        shoppingRecyclerList.adapter=adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            adapter.item=it
            adapter.notifyDataSetChanged()
        })

        floatingShopping.setOnClickListener {
            AddShoppingItemDialog(this,
                object: AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }

                }).show()
        }
    }
}
