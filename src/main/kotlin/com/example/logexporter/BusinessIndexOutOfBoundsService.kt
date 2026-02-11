package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessIndexOutOfBoundsService(@Autowired private val fetchIndexOutOfBoundsService: FetchIndexOutOfBoundsService) {
    private val logger = LoggerFactory.getLogger(BusinessIndexOutOfBoundsService::class.java)

    fun processIndexOutOfBounds(): String {
        logger.info("BusinessIndexOutOfBoundsService: Starting index out of bounds business logic.")
        return fetchIndexOutOfBoundsService.fetchIndexOutOfBounds()
    }
}
