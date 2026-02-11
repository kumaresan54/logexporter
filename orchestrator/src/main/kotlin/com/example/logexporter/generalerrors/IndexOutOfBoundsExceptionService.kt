package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class IndexOutOfBoundsExceptionService {
    private val logger = LoggerFactory.getLogger(IndexOutOfBoundsExceptionService::class.java)

    fun throwIndexOutOfBounds(): String {
        logger.info("IndexOutOfBoundsExceptionService: About to throw IndexOutOfBoundsException.")
        val list = listOf(1, 2, 3)
        val value = list[10] // Accessing out-of-bounds index
        return value.toString()
    }
}
