package com.junnosuke.translator_kmm.translate.domain.translate

import com.junnosuke.translator_kmm.core.domain.history.HistoryDataSource
import com.junnosuke.translator_kmm.core.domain.history.HistoryItem
import com.junnosuke.translator_kmm.core.domain.language.Language
import com.junnosuke.translator_kmm.core.domain.util.Resource

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage, fromText, toLanguage
            )
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText =  translatedText
                )
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}