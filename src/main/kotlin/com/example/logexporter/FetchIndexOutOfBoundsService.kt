package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchIndexOutOfBoundsService(@Autowired private val indexOutOfBoundsExceptionService: IndexOutOfBoundsExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchIndexOutOfBoundsService::class.java)

    fun fetchIndexOutOfBounds(): String {
        logger.info("FetchIndexOutOfBoundsService: Fetching index out of bounds error.")
        return indexOutOfBoundsExceptionService.throwIndexOutOfBounds()
    }
}
