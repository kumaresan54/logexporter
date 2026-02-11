package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.beans.factory.NoSuchBeanDefinitionException

@Service
class NoSuchBeanDefinitionExceptionService {
    private val logger = LoggerFactory.getLogger(NoSuchBeanDefinitionExceptionService::class.java)

    fun throwNoSuchBeanDefinition(): String {
        logger.info("NoSuchBeanDefinitionExceptionService: About to throw NoSuchBeanDefinitionException.")
        throw NoSuchBeanDefinitionException("Simulated no such bean definition error.")
    }
}
