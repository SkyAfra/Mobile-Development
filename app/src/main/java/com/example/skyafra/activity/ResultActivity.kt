package com.example.skyafra.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skyafra.databinding.ActivityResultBinding
import com.example.skyafra.history.HistoryItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra("result")
        val explanation = intent.getStringExtra("explanation")
        val suggestion = intent.getStringExtra("suggestion")

        if (result != null && explanation != null && suggestion != null) {
            val newHistoryItem = HistoryItem(result, explanation, suggestion)
            saveHistory(newHistoryItem)
        }

        binding.resultTextView.text = result
        binding.explanationTextView.text = explanation
        binding.suggestionTextView.text = suggestion

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, HomeCameraActivity::class.java))
            finish()
        }

    }

    private fun saveHistory(newItem: HistoryItem) {
        val sharedPreferences = getSharedPreferences("history", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val historyList = loadHistory()
        historyList.add(newItem)
        val json = Gson().toJson(historyList)
        editor.putString("history_list", json)
        editor.apply()
    }

    private fun loadHistory(): MutableList<HistoryItem> {
        val sharedPreferences = getSharedPreferences("history", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("history_list", null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<HistoryItem>>() {}.type
            Gson().fromJson(json, type)
        } else {
            mutableListOf()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

