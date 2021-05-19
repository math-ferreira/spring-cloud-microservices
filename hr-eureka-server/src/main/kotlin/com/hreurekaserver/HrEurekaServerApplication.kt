package com.hreurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class HrEurekaServerApplication

fun main(args: Array<String>) {
	runApplication<HrEurekaServerApplication>(*args)
}
