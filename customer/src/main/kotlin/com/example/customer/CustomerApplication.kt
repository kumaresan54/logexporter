package com.example.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.customer"])
class CustomerApplication

fun main(args: Array<String>) {
	runApplication<CustomerApplication>(*args)
}
