package com.example.currencyrate.screens.second

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyrate.R
import com.example.currencyrate.model.beznal.BezNalItem

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    var listSecond = emptyList<BezNalItem>()

    class SecondViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return SecondViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSecond.size
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_name).text = listSecond[position].title
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = listSecond[position].author
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = listSecond[position].description
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<BezNalItem>){
        listSecond = list
        notifyDataSetChanged()
    }

}