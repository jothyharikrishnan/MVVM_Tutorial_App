package com.example.mvvm_tutorial_app.room_database.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.room_database.data.UserViewModel
import com.example.mvvm_tutorial_app.room_database.model.User
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName.setText(args.currentUser.firstName)
        view.lastName.setText(args.currentUser.lastName)
        view.UpdateAge.setText(args.currentUser.age.toString())

        view.addBtn.setOnClickListener {
        updateItem()
        }

        return view
    }

    private fun updateItem(){
        val firstName=updateFirstName.text.toString()
        val lastName=lastName.text.toString()
        val age=Integer.parseInt(UpdateAge.text.toString())

        if (inputCheck(firstName,lastName,UpdateAge.text)){
            val updateUser= User(args.currentUser.id,firstName,lastName,age)

            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(),"Updated Successfully", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment2)

        }
        else{
            Toast.makeText(requireContext(),"Fill out all fields",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName:String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}