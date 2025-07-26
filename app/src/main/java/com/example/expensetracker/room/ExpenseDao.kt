package com.example.expensetracker.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.expensetracker.data.ExpenseData
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseData)

    @Query("SELECT * from ExpenseData ORDER by id DESC")
    fun getAllExpenses() : Flow<List<ExpenseData>>

    @Delete
    suspend fun deleteExpense(expense: ExpenseData)

}