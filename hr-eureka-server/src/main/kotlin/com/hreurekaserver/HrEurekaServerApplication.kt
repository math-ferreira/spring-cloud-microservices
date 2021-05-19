package com.hreurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HrEurekaServerApplication

fun main(args: Array<String>) {
	runApplication<HrEurekaServerApplication>(*args)
}
