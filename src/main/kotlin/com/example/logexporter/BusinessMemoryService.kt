package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BusinessMemoryService {
    private val logger = LoggerFactory.getLogger(BusinessMemoryService::class.java)

    fun processMemory(): String {
        logger.info("BusinessMemoryService: About to throw OutOfMemoryError.")
        // Allocate a large array to simulate OutOfMemoryError
        try {
            val arr = Array(Int.MAX_VALUE) { 0 }
        } catch (ex: OutOfMemoryError) {
            logger.error("BusinessMemoryService: Caught OutOfMemoryError", ex)
            throw ex
        }
        return "Should not reach here"
    }
}
