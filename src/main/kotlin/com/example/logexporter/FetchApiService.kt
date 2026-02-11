package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchApiService(@Autowired private val apiService: ApiService) {
    private val logger = LoggerFactory.getLogger(FetchApiService::class.java)

    fun fetchApiData(): String {
        logger.info("FetchApiService: Fetching API data.")
        return apiService.callApi()
    }
}
