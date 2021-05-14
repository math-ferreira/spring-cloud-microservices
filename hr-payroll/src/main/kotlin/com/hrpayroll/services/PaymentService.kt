package com.hrpayroll.services

import com.hrpayroll.entities.domain.Payment
import com.hrpayroll.entities.domain.Worker
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class PaymentService(
    private val restTemplate: RestTemplate,
    @Value("\${ht-worker.host}") private val workerHost: String
) {

    fun getPayment(workerId: Long, days: Int): Payment {
        val url = getWorkerUrl()
        val uriVariables = setVariableUri(workerId)
        val worker = this.restTemplate.getForObject<Worker>(url, Worker::class.java, uriVariables)

        return Payment(
            name = worker!!.name,
            dailyIncome = worker.dailyIncome,
            days = days
        )
    }

    private fun getWorkerUrl(): String {
        return "${this.workerHost}/workers/{id}"
    }

    private fun setVariableUri(workerId: Long): Map<String, String> {
        return mapOf("id" to "$workerId")
    }

}