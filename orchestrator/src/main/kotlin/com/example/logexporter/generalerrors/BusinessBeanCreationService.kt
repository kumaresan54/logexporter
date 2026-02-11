package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessBeanCreationService(@Autowired private val fetchBeanCreationService: FetchBeanCreationService) {
    private val logger = LoggerFactory.getLogger(BusinessBeanCreationService::class.java)

    fun processBeanCreation(): String {
        logger.info("BusinessBeanCreationService: Starting bean creation business logic.")
        return fetchBeanCreationService.fetchBeanCreation()
    }
}
