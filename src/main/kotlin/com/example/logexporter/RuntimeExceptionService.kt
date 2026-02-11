package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class RuntimeExceptionService {
    private val logger = LoggerFactory.getLogger(RuntimeExceptionService::class.java)

    fun throwRuntime(): String {
        logger.info("RuntimeExceptionService: About to throw RuntimeException.")
        throw RuntimeException("Simulated runtime exception: Something went wrong.")
    }
}
