package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessArithmeticService(@Autowired private val fetchArithmeticService: FetchArithmeticService) {
    private val logger = LoggerFactory.getLogger(BusinessArithmeticService::class.java)

    fun processArithmetic(): String {
        logger.info("BusinessArithmeticService: Starting arithmetic business logic.")
        return fetchArithmeticService.fetchArithmetic()
    }
}
