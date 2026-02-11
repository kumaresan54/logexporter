package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchHttpClientErrorService(@Autowired private val httpClientErrorExceptionService: HttpClientErrorExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchHttpClientErrorService::class.java)

    fun fetchHttpClientError(): String {
        logger.info("FetchHttpClientErrorService: Fetching HTTP client error.")
        return httpClientErrorExceptionService.throwHttpClientError()
    }
}
