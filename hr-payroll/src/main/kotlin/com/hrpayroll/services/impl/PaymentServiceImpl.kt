package com.hrpayroll.services.impl

import com.hrpayroll.clients.WorkerClient
import com.hrpayroll.entities.domain.Payment
import com.hrpayroll.entities.domain.Worker
import com.hrpayroll.services.PaymentService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PaymentServiceImpl(
    private val restTemplate: RestTemplate,
    private val workerClient: WorkerClient,
    @Value("\${ht-worker.host}") private val workerHost: String
) : PaymentService {

    override fun getPayment(workerId: Long, days: Int): Payment {
        val workerFeign = requestFeign(workerId)
        return Payment(
            name = workerFeign.name,
            dailyIncome = workerFeign.dailyIncome,
            days = days
        )
    }

    private fun requestRestTemplate(workerId: Long): Worker? {
        val url = getWorkerUrl()
        val uriVariables = setVariableUri(workerId)
        return this.restTemplate.getForObject<Worker>(url, Worker::class.java, uriVariables)
    }

    private fun requestFeign(workerId: Long): Worker {
        return this.workerClient.findById(workerId)
    }

    private fun getWorkerUrl(): String {
        return "${this.workerHost}/workers/{id}"
    }

    private fun setVariableUri(workerId: Long): Map<String, String> {
        return mapOf("id" to "$workerId")
    }

}