package com.example.dailynews.di

import com.example.dailynews.articles.di.articlesModule
import com.example.dailynews.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule,
    sourcesModule
)