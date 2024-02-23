package com.example.dailynews.android

import android.app.Application
import com.example.dailynews.android.di.databaseModule
import com.example.dailynews.android.di.viewModelsModule
import com.example.dailynews.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyNewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@DailyNewsApp)
            modules(modules)
        }
    }
}