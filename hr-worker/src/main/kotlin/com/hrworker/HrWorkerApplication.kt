package com.hrworker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HrWorkerApplication

fun main(args: Array<String>) {
	runApplication<HrWorkerApplication>(*args)
}
