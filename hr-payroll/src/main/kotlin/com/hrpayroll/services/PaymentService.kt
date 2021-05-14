package com.hrpayroll.services

import com.hrpayroll.entities.domain.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService {

    fun getPayment(workerId: Long, days: Int): Payment {
        return Payment(
            name = "Bob",
            dailyIncome = 200.0,
            days = days
        )
    }

}