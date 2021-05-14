package com.hrpayroll.entities.domain

class Payment(
    val name: String = "",
    val dailyIncome: Double = 0.0,
    val days: Int = 0
) {
    fun getTotal(): Double {
        return days * dailyIncome
    }
}