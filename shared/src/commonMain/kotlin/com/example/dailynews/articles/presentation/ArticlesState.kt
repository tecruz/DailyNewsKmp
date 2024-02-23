package com.example.dailynews.articles.presentation

import com.example.dailynews.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
