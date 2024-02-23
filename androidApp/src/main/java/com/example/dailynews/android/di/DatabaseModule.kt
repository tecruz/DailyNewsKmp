package com.example.dailynews.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.dailynews.db.DailyNewsDatabase
import com.example.dailynews.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyNewsDatabase> { DailyNewsDatabase(get()) }
}