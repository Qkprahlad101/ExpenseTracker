package com.example.expensetracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.data.ExpenseData
import com.example.expensetracker.domain.usecase.AddExpenseUseCase
import com.example.expensetracker.domain.usecase.DeleteExpenseUseCase
import com.example.expensetracker.domain.usecase.GetAllExpensesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExpensesViewModel(
    private val addExpenseUseCase: AddExpenseUseCase,
    private val deleteExpenseUseCase: DeleteExpenseUseCase,
    private val getAllExpensesUseCase: GetAllExpensesUseCase
) : ViewModel() {

    private val _expense = MutableStateFlow<List<ExpenseData>>(emptyList())
    val expense : StateFlow<List<ExpenseData>> = _expense.asStateFlow()

    init {
        loadExpenses()
    }

    fun loadExpenses() {
        viewModelScope.launch {
            getAllExpensesUseCase()
                .collect { expenseList ->
                    _expense.value = expenseList
                }
        }
    }

    fun addExpense(expense: ExpenseData) {
        viewModelScope.launch {
            addExpenseUseCase(expense)
            loadExpenses()
        }
    }

    fun deleteExpense(expense: ExpenseData) {
        viewModelScope.launch {
            deleteExpenseUseCase(expense)
            loadExpenses()
        }
    }
}