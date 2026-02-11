package com.example.pricing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.pricing"])
class PricingApplication

fun main(args: Array<String>) {
	runApplication<PricingApplication>(*args)
}
