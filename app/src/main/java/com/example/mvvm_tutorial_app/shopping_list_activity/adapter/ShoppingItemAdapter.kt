package com.example.mvvm_tutorial_app.shopping_list_activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_tutorial_app.R
import com.example.mvvm_tutorial_app.shopping_list_activity.ShoppingItem
import com.example.mvvm_tutorial_app.shopping_list_activity.data.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var item:List<ShoppingItem>,
    private val viewModel:ShoppingViewModel
) :RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem=item[position]

        holder.itemView.textName.text=currentShoppingItem.name
        holder.itemView.textAmount.text="${currentShoppingItem.amount}"

        holder.itemView.tvDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemView.tvPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.itemView.tvMin.setOnClickListener {
            if (currentShoppingItem.amount>0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }

        }

    }
}