package com.example.expensetracker.data.di

import androidx.room.Room
import com.example.expensetracker.data.ExpenseRepositoryImpl
import com.example.expensetracker.room.AppDatabase
import com.example.expensetracker.domain.ExpenseRepository
import com.example.expensetracker.domain.usecase.AddExpenseUseCase
import com.example.expensetracker.domain.usecase.DeleteExpenseUseCase
import com.example.expensetracker.domain.usecase.GetAllExpensesUseCase
import org.koin.dsl.module
import kotlin.jvm.java

val appModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "expense_db").build() }
    single { get<AppDatabase>().expenseDao()}
    single<ExpenseRepository> { ExpenseRepositoryImpl(get()) }
    single { AddExpenseUseCase(get()) }
    single { DeleteExpenseUseCase(get()) }
    single { GetAllExpensesUseCase(get()) }
}