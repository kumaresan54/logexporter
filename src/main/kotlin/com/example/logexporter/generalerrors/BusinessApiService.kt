package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.HttpClientErrorException

@Service
class BusinessApiService {
    private val logger = LoggerFactory.getLogger(BusinessApiService::class.java)
    private val restTemplate = RestTemplate()

    fun processApi(): String {
        logger.info("BusinessApiService: Making HTTP call to invalid API endpoint.")
        // This should trigger a client error (e.g., 404) from an invalid endpoint
        try {
            restTemplate.getForObject("https://httpstat.us/404", String::class.java)
        } catch (ex: HttpClientErrorException) {
            logger.error("BusinessApiService: Caught HttpClientErrorException", ex)
            throw ex
        }
        return "Should not reach here"
    }
}
