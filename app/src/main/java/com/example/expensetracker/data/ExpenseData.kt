package com.example.expensetracker.data

import android.os.Parcelable
import com.example.common.data.BaseDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExpenseData(
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
