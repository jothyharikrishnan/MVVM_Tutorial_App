package com.example.mvvm_tutorial_app.room_database.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mvvm_tutorial_app.R

class RoomDatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController=findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()

        return super.onSupportNavigateUp()
    }
}
