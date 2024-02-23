package com.example.dailynews.android.di

import com.example.dailynews.articles.presentation.ArticlesViewModel
import com.example.dailynews.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}