package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessService(@Autowired private val fetchService: FetchService) {
    private val logger = LoggerFactory.getLogger(BusinessService::class.java)

    fun process(): String {
        logger.info("BusinessService: Starting business logic.")
        return fetchService.fetchData()
    }
}
