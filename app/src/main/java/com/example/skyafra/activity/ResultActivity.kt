package com.example.skyafra.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skyafra.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra("result")
        val explanation = intent.getStringExtra("explanation")
        val suggestion = intent.getStringExtra("suggestion")

        binding.resultTextView.text = result
        binding.explanationTextView.text = explanation
        binding.suggestionTextView.text = suggestion

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}