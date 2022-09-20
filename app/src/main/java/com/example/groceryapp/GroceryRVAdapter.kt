package com.example.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grocery_rv_item.view.*

class GroceryRVAdapter(var list: List<GroceryItems>,val groceryitemClickInterface: GroceryItemClickInterface):
RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>(){

    inner class GroceryViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val nameTV = itemView.idTVItemName
        val quantityTV = itemView.idTVQuantity
        val rateTV = itemView.idTVRate
        val amountTV = itemView.idTVTotalAmt
        val deleteTV = itemView.idTVDelete
    }

    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text = list.get(position).itemName
        holder.quantityTV.text=list.get(position).itemQuantity.toString()
        holder.rateTV.text=list.get(position).itemPrice.toString()
        val itemTotal:Int=list.get(position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text="Rs. "+itemTotal.toString()
        holder.deleteTV.setOnClickListener{
            groceryitemClickInterface.onItemClick(list.get(position))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}