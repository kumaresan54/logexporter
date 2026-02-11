package com.example.logexporter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogExporterApplication

fun main(args: Array<String>) {
	runApplication<LogExporterApplication>(*args)
}
