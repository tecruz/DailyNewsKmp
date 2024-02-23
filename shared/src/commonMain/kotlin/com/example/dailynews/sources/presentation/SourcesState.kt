package com.example.dailynews.sources.presentation

import com.example.dailynews.sources.domain.Source

data class SourcesState(
    val sources: List<Source> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
