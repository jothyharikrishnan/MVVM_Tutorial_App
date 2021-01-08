package com.example.mvvm_tutorial_app.room_database.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.room_database.model.User
import com.example.mvvm_tutorial_app.room_database.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

        private lateinit var mUserViewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        view.addBtn.setOnClickListener {
            insertDataTODatabase()
        }
        return view
    }

    private fun insertDataTODatabase() {
        val firstName=firstName.text.toString()
        val lastName=lastName.text.toString()
        val age=age.text

        if (inputCheck(firstName,lastName,age)){
            val user= User(
                0,
                firstName,
                lastName,
                Integer.parseInt(age.toString())
            )
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else
        {
            Toast.makeText(requireContext(),"Fill out all fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName:String,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}