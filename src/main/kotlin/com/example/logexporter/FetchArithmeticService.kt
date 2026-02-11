package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchArithmeticService(@Autowired private val arithmeticExceptionService: ArithmeticExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchArithmeticService::class.java)

    fun fetchArithmetic(): String {
        logger.info("FetchArithmeticService: Fetching arithmetic error.")
        return arithmeticExceptionService.throwArithmetic()
    }
}
