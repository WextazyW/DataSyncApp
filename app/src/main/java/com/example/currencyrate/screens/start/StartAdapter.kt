package com.example.currencyrate.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.currencyrate.R
import com.example.currencyrate.model.nal.Nal
import com.example.currencyrate.model.nal.NalItem

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>(){

    private var listStart = emptyList<NalItem>()

    class StartViewHolder(view : View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_name).text = listStart[position].title
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = listStart[position].author
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = listStart[position].description
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NalItem>){
        listStart = list
        notifyDataSetChanged()
    }
}