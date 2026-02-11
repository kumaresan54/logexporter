package com.example.vehicle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.vehicle"])
class VehicleApplication

fun main(args: Array<String>) {
	runApplication<VehicleApplication>(*args)
}
