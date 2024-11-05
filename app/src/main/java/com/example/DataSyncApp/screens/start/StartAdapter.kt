package com.example.DataSyncApp.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.DataSyncApp.R
import com.example.DataSyncApp.model.reader.ReaderItem

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>(){

    private var listStart = emptyList<ReaderItem>()

    class StartViewHolder(view : View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_name).text = listStart[position].firstName
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = listStart[position].lastName
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = listStart[position].contactDetails.toString()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ReaderItem>){
        listStart = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: StartViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickMovie(listStart[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: StartViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}