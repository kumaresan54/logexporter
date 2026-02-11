package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.beans.factory.BeanCreationException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.function.Supplier

@Service
class BeanCreationExceptionService {
    private val logger = LoggerFactory.getLogger(BeanCreationExceptionService::class.java)

    fun throwBeanCreation(): String {
        logger.info("BeanCreationExceptionService: Attempting to create bean with invalid configuration.")
        // Attempt to create a bean with invalid configuration
        try {
            val context = AnnotationConfigApplicationContext()
            context.registerBean("invalidBean", String::class.java, Supplier { throw BeanCreationException("Simulated bean creation error.") })
            context.refresh()
        } catch (ex: BeanCreationException) {
            logger.error("BeanCreationExceptionService: Caught BeanCreationException", ex)
            throw ex
        }
        return "Should not reach here"
    }
}
