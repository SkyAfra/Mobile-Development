package com.example.skyafra.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUrl: String,
    val result: String,
    val explanation: String,
    val suggestion: String,
    val confidenceScore: Double,
    val createdAt: String
)
