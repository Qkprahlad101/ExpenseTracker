package com.example.expensetracker

import android.app.Application
import com.example.expensetracker.data.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExpenseTrackerApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ExpenseTrackerApplication)
            modules(appModule)
        }
    }
}