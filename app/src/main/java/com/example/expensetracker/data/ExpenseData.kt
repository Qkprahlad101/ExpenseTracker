package com.example.expensetracker.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.data.BaseDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "expenses")
data class ExpenseData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val cost: Double = 0.0,
    val category: ExpenseCategories = ExpenseCategories.MISCELLANEOUS
) : BaseDataClass, Parcelable

enum class ExpenseCategories {
    FOOD,
    TRAVEL,
    CCBILL,
    SHOPPING,
    MISCELLANEOUS
}
