package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ApiService {
    private val logger = LoggerFactory.getLogger(ApiService::class.java)

    fun callApi(): String {
        logger.info("ApiService: Calling external API.")
        throw RuntimeException("Simulated API exception: Timeout occurred.")
    }
}
