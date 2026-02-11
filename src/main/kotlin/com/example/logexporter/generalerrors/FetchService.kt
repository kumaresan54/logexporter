package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchService(@Autowired private val dbService: DbService) {
    private val logger = LoggerFactory.getLogger(FetchService::class.java)

    fun fetchData(): String {
        logger.info("FetchService: Fetching data.")
        return dbService.queryDb()
    }
}
