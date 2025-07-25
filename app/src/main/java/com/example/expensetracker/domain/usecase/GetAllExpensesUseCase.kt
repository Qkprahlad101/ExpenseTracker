package com.example.expensetracker.domain.usecase

import com.example.expensetracker.domain.ExpenseRepository

class GetAllExpensesUseCase(private val repository: ExpenseRepository) {
    operator fun invoke() = repository.getAllExpenses()
}