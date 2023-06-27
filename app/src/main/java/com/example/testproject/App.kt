package com.example.testproject

import android.app.Application
import com.example.testproject.di.appModule
import com.example.testproject.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, repositoryModule)
        }
    }
}