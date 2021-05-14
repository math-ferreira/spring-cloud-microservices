package com.hrpayroll.controller

import com.hrpayroll.entities.domain.Payment
import com.hrpayroll.services.PaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/payments"])
class PaymentController(
    private val paymentService: PaymentService
) {

    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(
        @PathVariable("workerId") workerId: Long,
        @PathVariable("days") days: Int
    ): ResponseEntity<Payment> {
        val payment = this.paymentService.getPayment(workerId, days)
        return ResponseEntity.ok(payment)
    }
}