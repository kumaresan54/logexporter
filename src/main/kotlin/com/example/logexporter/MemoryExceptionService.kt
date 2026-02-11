package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MemoryExceptionService {
    private val logger = LoggerFactory.getLogger(MemoryExceptionService::class.java)

    fun throwMemory(): String {
        logger.info("MemoryExceptionService: About to throw OutOfMemoryError.")
        throw OutOfMemoryError("Simulated out-of-memory error.")
    }
}
