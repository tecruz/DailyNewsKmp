package com.example.dailynews.sources.domain

import com.example.dailynews.sources.data.SourceRaw
import com.example.dailynews.sources.data.SourcesRepository

class SourcesUseCase(private val repo: SourcesRepository) {

    suspend fun getSources(forceFetch: Boolean): List<Source> {
        val sourcesRaw = repo.getSources(forceFetch)
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            raw.id,
            raw.name,
            raw.desc,
            mapOrigin(raw)
        )
    }

    private fun mapOrigin(raw: SourceRaw) = "${raw.country} - ${raw.language}"
}