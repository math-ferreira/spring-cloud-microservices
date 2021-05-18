package com.hrpayroll.services

import com.hrpayroll.entities.domain.Payment

interface PaymentService {

    fun getPayment(workerId: Long, days: Int): Payment
}