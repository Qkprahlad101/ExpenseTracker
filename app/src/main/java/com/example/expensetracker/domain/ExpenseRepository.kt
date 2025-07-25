package com.example.expensetracker.domain

import com.example.expensetracker.data.model.ExpenseData
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    suspend fun addExpense(expense: ExpenseData)
    fun getAllExpenses(): Flow<List<ExpenseData>>
    suspend fun deleteExpense(expense: ExpenseData)
}