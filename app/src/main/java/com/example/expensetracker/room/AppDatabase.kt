package com.example.expensetracker.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.data.model.ExpenseData

@Database(entities = [ExpenseData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao() : ExpenseDao
}