package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchNullService(@Autowired private val nullPointerExceptionService: NullPointerExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchNullService::class.java)

    fun fetchNull(): String {
        logger.info("FetchNullService: Fetching null pointer error.")
        return nullPointerExceptionService.throwNull()
    }
}
