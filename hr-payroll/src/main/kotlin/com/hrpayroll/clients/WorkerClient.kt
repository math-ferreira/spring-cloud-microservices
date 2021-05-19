package com.hrpayroll.clients

import com.hrpayroll.entities.domain.Worker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(name = "hr-worker", path = "/workers")
interface WorkerClient {

    @GetMapping(value = ["/{id}"])
    fun findById(
        @PathVariable("id") id: Long
    ): Worker
}