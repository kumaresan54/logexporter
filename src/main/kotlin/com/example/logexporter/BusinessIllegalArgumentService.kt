package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessIllegalArgumentService(@Autowired private val fetchIllegalArgumentService: FetchIllegalArgumentService) {
    private val logger = LoggerFactory.getLogger(BusinessIllegalArgumentService::class.java)

    fun processIllegalArgument(): String {
        logger.info("BusinessIllegalArgumentService: Starting illegal argument business logic.")
        return fetchIllegalArgumentService.fetchIllegalArgument()
    }
}
