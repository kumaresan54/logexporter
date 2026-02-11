package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessNullService(@Autowired private val fetchNullService: FetchNullService) {
    private val logger = LoggerFactory.getLogger(BusinessNullService::class.java)

    fun processNull(): String {
        logger.info("BusinessNullService: Starting null pointer business logic.")
        return fetchNullService.fetchNull()
    }
}
