package com.example.skyafra.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.skyafra.dao.HistoryDao
import com.example.skyafra.dao.HistoryItem
import com.example.skyafra.database.AppDatabase
import com.example.skyafra.databinding.ActivityResultBinding
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var historyDao: HistoryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = AppDatabase.getDatabase(this)
        historyDao = database.historyDao()

        val result = intent.getStringExtra("result")
        val explanation = intent.getStringExtra("explanation")
        val suggestion = intent.getStringExtra("suggestion")
        val imageUrl = intent.getStringExtra("imageUrl")
        val createdAt = intent.getStringExtra("createdAt")

        binding.resultTextView.text = result
        binding.explanationTextView.text = explanation
        binding.suggestionTextView.text = suggestion

        binding.backButton.setOnClickListener {
            saveResultToDatabase(result, explanation, suggestion, imageUrl, createdAt)
            startActivity(Intent(this, HomeCameraActivity::class.java))
        }

    }

    private fun saveResultToDatabase(result: String?, explanation: String?, suggestion: String?, imageUrl: String?, createdAt: String?) {
        if (result != null && explanation != null && suggestion != null && imageUrl != null && createdAt != null) {
            val historyItem = HistoryItem(
                result = result,
                explanation = explanation,
                suggestion = suggestion,
                imageUrl = imageUrl,
                confidenceScore = 0.0,
                createdAt = createdAt
            )

            lifecycleScope.launch {
                historyDao.insert(historyItem)
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}