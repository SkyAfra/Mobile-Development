package com.example.skyafra.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skyafra.databinding.ActivityHistoryBinding
import com.example.skyafra.adapter.HistoryAdapter
import com.example.skyafra.history.HistoryItem
import com.example.skyafra.history.SpacingItemDecoration
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var historyList: MutableList<HistoryItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        historyList = loadHistory()

        historyAdapter = HistoryAdapter(historyList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = historyAdapter
            addItemDecoration(SpacingItemDecoration(24))
        }
    }

    private fun loadHistory(): MutableList<HistoryItem> {
        val sharedPreferences = getSharedPreferences("history", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("history_list", null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<HistoryItem>>() {}.type
            val historyList: MutableList<HistoryItem> = Gson().fromJson(json, type)
            historyList.reverse()
            historyList
        } else {
            mutableListOf()
        }
    }
}
