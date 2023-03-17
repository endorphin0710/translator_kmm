package com.junnosuke.translator_kmm.translate.data.history

import com.junnosuke.translator_kmm.core.domain.history.HistoryDataSource
import com.junnosuke.translator_kmm.core.domain.history.HistoryItem
import com.junnosuke.translator_kmm.core.domain.util.CommonFlow
import com.junnosuke.translator_kmm.core.domain.util.toCommonFlow
import com.junnosuke.translator_kmm.database.TranslateDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import toHistoryItem

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
): HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }

}