package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class IllegalArgumentExceptionService {
    private val logger = LoggerFactory.getLogger(IllegalArgumentExceptionService::class.java)

    fun throwIllegalArgument(): String {
        logger.info("IllegalArgumentExceptionService: About to throw IllegalArgumentException.")
        val input: String? = null
        requireNotNull(input) { "Simulated illegal argument: input must not be null" }
        return "Should not reach here"
    }
}
