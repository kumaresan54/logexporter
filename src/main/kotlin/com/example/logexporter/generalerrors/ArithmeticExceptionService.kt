package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ArithmeticExceptionService {
    private val logger = LoggerFactory.getLogger(ArithmeticExceptionService::class.java)

    fun throwArithmetic(): String {
        logger.info("ArithmeticExceptionService: About to throw ArithmeticException.")
        val x = 1
        val y = 0
        val result = x / y // Division by zero
        return result.toString()
    }
}
