package com.example.mvvm_tutorial_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_tutorial_app.crud_app.CrudMainActivity
import com.example.mvvm_tutorial_app.room_database.activity.RoomDatabaseActivity
import com.example.mvvm_tutorial_app.shopping_list_activity.ShoppingListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shopBtn.setOnClickListener {
            Intent(this,ShoppingListActivity::class.java).also {
                startActivity(it)
            }
        }
        roomBtn.setOnClickListener {
            Intent(this,
                RoomDatabaseActivity::class.java).also {
                startActivity(it)
            }
        }
        retroBtn.setOnClickListener {
            Intent(this,
                CrudMainActivity::class.java).also {
                startActivity(it)
            }
            }
        }
    }

