package com.example.skyafra.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.skyafra.dao.HistoryDao
import com.example.skyafra.dao.HistoryItem
import com.example.skyafra.database.AppDatabase

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private val historyDao: HistoryDao = AppDatabase.getDatabase(application).historyDao()
    val allHistory: LiveData<List<HistoryItem>> = historyDao.getAllHistory()
}
