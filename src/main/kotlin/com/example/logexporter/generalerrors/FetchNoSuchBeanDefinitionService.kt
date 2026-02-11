package com.example.logexporter.generalerrors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchNoSuchBeanDefinitionService(@Autowired private val noSuchBeanDefinitionExceptionService: NoSuchBeanDefinitionExceptionService) {
    private val logger = LoggerFactory.getLogger(FetchNoSuchBeanDefinitionService::class.java)

    fun fetchNoSuchBeanDefinition(): String {
        logger.info("FetchNoSuchBeanDefinitionService: Fetching no such bean definition error.")
        return noSuchBeanDefinitionExceptionService.throwNoSuchBeanDefinition()
    }
}
