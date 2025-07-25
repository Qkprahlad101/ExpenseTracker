package com.example.expensetracker.domain.usecase

import com.example.expensetracker.data.model.ExpenseData
import com.example.expensetracker.domain.ExpenseRepository

class DeleteExpenseUseCase(private val repository: ExpenseRepository) {

    suspend operator fun invoke(expense: ExpenseData) = repository.deleteExpense(expense)
}