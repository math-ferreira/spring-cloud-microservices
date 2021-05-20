package com.hrapigatewayzull

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZuulServerApplication

fun main(args: Array<String>) {
	runApplication<ZuulServerApplication>(*args)
}
