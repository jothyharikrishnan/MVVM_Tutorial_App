package com.example.mvvm_tutorial_app.crud_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.crud_app.db.Subscriber
import com.example.mvvm_tutorial_app.databinding.CrudListItemBinding


class MyRecyclerViewAdapter(private val subscriberList:List<Subscriber>,private val clickListener:(Subscriber)->Unit):RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding:CrudListItemBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(subscriber:Subscriber,clickListener:(Subscriber)->Unit){
            binding.txtSubName.text=subscriber.name
            binding.txtSubEmail.text=subscriber.email
            binding.cardView.setOnClickListener {
                clickListener(subscriber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:CrudListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.crud_list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return subscriberList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(subscriberList[position],clickListener)
    }
}