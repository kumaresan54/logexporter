package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessHttpServerErrorService(@Autowired private val fetchHttpServerErrorService: FetchHttpServerErrorService) {
    private val logger = LoggerFactory.getLogger(BusinessHttpServerErrorService::class.java)

    fun processHttpServerError(): String {
        logger.info("BusinessHttpServerErrorService: Starting HTTP server error business logic.")
        return fetchHttpServerErrorService.fetchHttpServerError()
    }
}
