package com.example.expensetracker.data

import com.example.expensetracker.domain.ExpenseRepository
import com.example.expensetracker.room.ExpenseDao
import kotlinx.coroutines.flow.Flow

class ExpenseRepositoryImpl(private val expenseDao: ExpenseDao): ExpenseRepository {

    override suspend fun addExpense(expense: ExpenseData) = expenseDao.insertExpense(expense)

    override fun getAllExpenses(): Flow<List<ExpenseData>> = expenseDao.getAllExpenses()

    override suspend fun deleteExpense(expense: ExpenseData) = expenseDao.deleteExpense(expense)
}