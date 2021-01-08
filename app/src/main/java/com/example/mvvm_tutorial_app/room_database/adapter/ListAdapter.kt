package com.example.mvvm_tutorial_app.room_database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.room_database.fragments.ListFragmentDirections
import com.example.mvvm_tutorial_app.room_database.model.User
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList= emptyList<User>()

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=userList[position]
        holder.itemView.textId.text=currentItem.id.toString()
        holder.itemView.textFirst.text=currentItem.firstName
        holder.itemView.textLast.text=currentItem.lastName
        holder.itemView.textAge.text=currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {

            val actions=ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(actions)
        }
    }

    fun setData(user:List<User>){
        this.userList=user
        notifyDataSetChanged()
    }
}