package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchHttpServerErrorService(@Autowired private val httpServerErrorExceptionService: HttpServerErrorExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchHttpServerErrorService::class.java)

    fun fetchHttpServerError(): String {
        logger.info("FetchHttpServerErrorService: Fetching HTTP server error.")
        return httpServerErrorExceptionService.throwHttpServerError()
    }
}
