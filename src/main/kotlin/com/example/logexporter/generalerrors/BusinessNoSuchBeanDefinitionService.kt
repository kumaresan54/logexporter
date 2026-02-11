package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class BusinessNoSuchBeanDefinitionService(@Autowired private val applicationContext: ApplicationContext) {
    private val logger = LoggerFactory.getLogger(BusinessNoSuchBeanDefinitionService::class.java)

    fun processNoSuchBeanDefinition(): String {
        logger.info("BusinessNoSuchBeanDefinitionService: Attempting to load invalid bean.")
        // Attempt to get a bean that does not exist
        applicationContext.getBean("invalidBeanName")
        return "Should not reach here"
    }
}
