package ru.abelyh.bin_info.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.abelyh.bin_info.R

class HistoryListAdapter(private val binNumber: ArrayList<String>) :
    RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subTitle.text = binNumber[position]
    }

    override fun getItemCount(): Int = binNumber.size

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val subTitle: TextView = itemView.findViewById(R.id.history_list_item_subtitle)
    }
}