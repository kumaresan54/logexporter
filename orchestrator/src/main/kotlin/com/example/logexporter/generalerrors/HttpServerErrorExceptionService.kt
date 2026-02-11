package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.getForObject

@Service
class HttpServerErrorExceptionService {
    private val logger = LoggerFactory.getLogger(HttpServerErrorExceptionService::class.java)
    private val restTemplate = RestTemplate()

    fun throwHttpServerError(): String {
        logger.info("HttpServerErrorExceptionService: Making HTTP call to invalid server endpoint.")
        // This should trigger a server error (e.g., 500) from an invalid endpoint
        try {
            restTemplate.getForObject<String>("https://httpstat.us/500")
        } catch (ex: HttpServerErrorException) {
            logger.error("HttpServerErrorExceptionService: Caught HttpServerErrorException", ex)
            throw ex
        }
        return "Should not reach here"
    }
}
