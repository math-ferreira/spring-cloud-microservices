package com.hrpayroll.controller

import com.hrpayroll.entities.domain.Payment
import com.hrpayroll.services.PaymentService
import com.hrpayroll.services.impl.PaymentServiceImpl
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.ribbon.proxy.annotation.Hystrix
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

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(
        @PathVariable("workerId") workerId: Long,
        @PathVariable("days") days: Int
    ): ResponseEntity<Payment> {
        Thread.sleep(100000)
        val payment = this.paymentService.getPayment(workerId, days)
        return ResponseEntity.ok(payment)
    }

    fun getPaymentAlternative(workerId: Long, days: Int): ResponseEntity<Payment> {
        val payment = Payment(
            name = "Brann",
            dailyIncome = 400.00,
            days = days
        )
        return ResponseEntity.ok(payment)
    }
}