package com.example.skyafra.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skyafra.R
import com.example.skyafra.history.HistoryItem

class HistoryAdapter(private val historyList: List<HistoryItem>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resultTextView: TextView = itemView.findViewById(R.id.resultTextView)
        val explanationTextView: TextView = itemView.findViewById(R.id.explanationTextView)
        val suggestionTextView: TextView = itemView.findViewById(R.id.suggestionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = historyList[position]
        holder.resultTextView.text = currentItem.result
        holder.explanationTextView.text = currentItem.explanation
        holder.suggestionTextView.text = currentItem.suggestion
    }

    override fun getItemCount() = historyList.size
}
