package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BusinessRuntimeService {
    private val logger = LoggerFactory.getLogger(BusinessRuntimeService::class.java)

    fun processRuntime(): String {
        logger.info("BusinessRuntimeService: About to throw RuntimeException.")
        throw RuntimeException("Simulated runtime exception: Something went wrong.")
    }
}
