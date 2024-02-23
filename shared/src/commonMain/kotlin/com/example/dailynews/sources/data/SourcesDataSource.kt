package com.example.dailynews.sources.data

import com.example.dailynews.db.DailyNewsDatabase

class SourcesDataSource(private val database: DailyNewsDatabase) {
    fun getAllSources(): List<SourceRaw> =
        database.dailyNewsDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(articles: List<SourceRaw>) {
        database.dailyNewsDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertSource(articleRaw)
            }
        }
    }

    fun clearSources() =
        database.dailyNewsDatabaseQueries.removeAllArticles()

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dailyNewsDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.desc,
            sourceRaw.language,
            sourceRaw.country
        )
    }

    private fun mapToSourceRaw(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ): SourceRaw =
        SourceRaw(
            id,
            name,
            desc,
            language,
            country
        )
}