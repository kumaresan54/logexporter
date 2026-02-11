package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.HttpClientErrorException

@Service
class HttpClientErrorExceptionService {
    private val logger = LoggerFactory.getLogger(HttpClientErrorExceptionService::class.java)
    private val restTemplate = RestTemplate()

    fun throwHttpClientError(): String {
        logger.info("HttpClientErrorExceptionService: Making HTTP call to invalid client endpoint.")
        // This should trigger a client error (e.g., 400) from an invalid endpoint
        try {
            restTemplate.getForObject("https://httpstat.us/400", String::class.java)
        } catch (ex: HttpClientErrorException) {
            logger.error("HttpClientErrorExceptionService: Caught HttpClientErrorException", ex)
            throw ex
        }
        return "Should not reach here"
    }
}
