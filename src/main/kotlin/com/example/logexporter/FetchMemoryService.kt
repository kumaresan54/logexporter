package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchMemoryService(@Autowired private val memoryExceptionService: MemoryExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchMemoryService::class.java)

    fun fetchMemory(): String {
        logger.info("FetchMemoryService: Fetching memory error.")
        return memoryExceptionService.throwMemory()
    }
}
