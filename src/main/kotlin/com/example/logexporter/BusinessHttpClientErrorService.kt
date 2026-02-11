package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessHttpClientErrorService(@Autowired private val fetchHttpClientErrorService: FetchHttpClientErrorService) {
    private val logger = LoggerFactory.getLogger(BusinessHttpClientErrorService::class.java)

    fun processHttpClientError(): String {
        logger.info("BusinessHttpClientErrorService: Starting HTTP client error business logic.")
        return fetchHttpClientErrorService.fetchHttpClientError()
    }
}
