package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchIllegalArgumentService(@Autowired private val illegalArgumentExceptionService: IllegalArgumentExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchIllegalArgumentService::class.java)

    fun fetchIllegalArgument(): String {
        logger.info("FetchIllegalArgumentService: Fetching illegal argument error.")
        return illegalArgumentExceptionService.throwIllegalArgument()
    }
}
