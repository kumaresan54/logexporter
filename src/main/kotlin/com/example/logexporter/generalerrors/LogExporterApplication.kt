package com.example.logexporter.generalerrors

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.logexporter"])
class LogExporterApplication

fun main(args: Array<String>) {
	runApplication<LogExporterApplication>(*args)
}
