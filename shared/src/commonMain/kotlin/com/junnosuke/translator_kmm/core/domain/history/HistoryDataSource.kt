package com.junnosuke.translator_kmm.core.domain.history

import com.junnosuke.translator_kmm.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}