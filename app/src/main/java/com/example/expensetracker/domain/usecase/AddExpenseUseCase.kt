package com.example.expensetracker.domain.usecase

import com.example.expensetracker.data.model.ExpenseData
import com.example.expensetracker.domain.ExpenseRepository

class AddExpenseUseCase(private val repository: ExpenseRepository) {
    suspend operator fun invoke(expense: ExpenseData) = repository.addExpense(expense)
}