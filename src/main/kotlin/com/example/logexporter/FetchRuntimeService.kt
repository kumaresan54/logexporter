package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchRuntimeService(@Autowired private val runtimeExceptionService: RuntimeExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchRuntimeService::class.java)

    fun fetchRuntime(): String {
        logger.info("FetchRuntimeService: Fetching runtime error.")
        return runtimeExceptionService.throwRuntime()
    }
}
