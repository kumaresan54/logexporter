package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchBeanCreationService(@Autowired private val beanCreationExceptionService: BeanCreationExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchBeanCreationService::class.java)

    fun fetchBeanCreation(): String {
        logger.info("FetchBeanCreationService: Fetching bean creation error.")
        return beanCreationExceptionService.throwBeanCreation()
    }
}
