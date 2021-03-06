package com.hrpayroll

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
class HrPayrollApplication

fun main(args: Array<String>) {
	runApplication<HrPayrollApplication>(*args)
}
