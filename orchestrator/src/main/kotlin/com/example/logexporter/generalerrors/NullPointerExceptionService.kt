package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NullPointerExceptionService {
    private val logger = LoggerFactory.getLogger(NullPointerExceptionService::class.java)

    fun throwNull(): String {
        logger.info("NullPointerExceptionService: About to throw NullPointerException.")
        val obj: String? = null
        val length = obj!!.length // Force null pointer exception
        return length.toString()
    }
}
