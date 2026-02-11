package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class LogController @Autowired constructor(
    private val businessService: BusinessService,
    private val businessApiService: BusinessApiService,
    private val businessRuntimeService: BusinessRuntimeService,
    private val businessMemoryService: BusinessMemoryService,
    private val businessNullService: BusinessNullService,
    private val businessIllegalArgumentService: BusinessIllegalArgumentService,
    private val businessArithmeticService: BusinessArithmeticService,
    private val businessIndexOutOfBoundsService: BusinessIndexOutOfBoundsService,
    private val businessHttpServerErrorService: BusinessHttpServerErrorService,
    private val businessHttpClientErrorService: BusinessHttpClientErrorService,
    private val businessBeanCreationService: BusinessBeanCreationService,
    private val businessNoSuchBeanDefinitionService: BusinessNoSuchBeanDefinitionService
) {
    private val logger = LoggerFactory.getLogger(LogController::class.java)

    @GetMapping("/log")
    fun logMessage(): String {
        logger.info("LogController: Invoking business service.")
        return try {
            businessService.process()
        } catch (ex: Exception) {
            logger.error("Error occurred in log flow", ex)
            "Error: ${ex.message}"
        }
    }

    @GetMapping("/log-api")
    fun logApiMessage(): String {
        logger.info("LogController: Invoking business API service.")
        return try {
            businessApiService.processApi()
        } catch (ex: Exception) {
            logger.error("API Error occurred in log flow", ex)
            "API Error: ${ex.message}"
        }
    }

    @GetMapping("/log-runtime")
    fun logRuntimeMessage(): String {
        logger.info("LogController: Invoking business runtime service.")
        return try {
            businessRuntimeService.processRuntime()
        } catch (ex: Exception) {
            logger.error("Runtime Error occurred in log flow", ex)
            "Runtime Error: ${ex.message}"
        }
    }

    @GetMapping("/log-memory")
    fun logMemoryMessage(): String {
        logger.info("LogController: Invoking business memory service.")
        return try {
            businessMemoryService.processMemory()
        } catch (ex: OutOfMemoryError) {
            logger.error("Memory Error occurred in log flow", ex)
            "Memory Error: ${ex.message}"
        }
    }

    @GetMapping("/log-null")
    fun logNullMessage(): String {
        logger.info("LogController: Invoking business null service.")
        return try {
            businessNullService.processNull()
        } catch (ex: NullPointerException) {
            logger.error("Null Pointer Error occurred in log flow", ex)
            "Null Pointer Error: ${ex.message}"
        }
    }

    @GetMapping("/log-illegal-argument")
    fun logIllegalArgumentMessage(): String {
        logger.info("LogController: Invoking business illegal argument service.")
        return try {
            businessIllegalArgumentService.processIllegalArgument()
        } catch (ex: IllegalArgumentException) {
            logger.error("Illegal Argument Error occurred in log flow", ex)
            "Illegal Argument Error: ${ex.message}"
        }
    }

    @GetMapping("/log-arithmetic")
    fun logArithmeticMessage(): String {
        logger.info("LogController: Invoking business arithmetic service.")
        return try {
            businessArithmeticService.processArithmetic()
        } catch (ex: ArithmeticException) {
            logger.error("Arithmetic Error occurred in log flow", ex)
            "Arithmetic Error: ${ex.message}"
        }
    }

    @GetMapping("/log-index-out-of-bounds")
    fun logIndexOutOfBoundsMessage(): String {
        logger.info("LogController: Invoking business index out of bounds service.")
        return try {
            businessIndexOutOfBoundsService.processIndexOutOfBounds()
        } catch (ex: IndexOutOfBoundsException) {
            logger.error("Index Out Of Bounds Error occurred in log flow", ex)
            "Index Out Of Bounds Error: ${ex.message}"
        }
    }

    @GetMapping("/log-http-server-error")
    fun logHttpServerErrorMessage(): String {
        logger.info("LogController: Invoking business HTTP server error service.")
        return try {
            businessHttpServerErrorService.processHttpServerError()
        } catch (ex: org.springframework.web.client.HttpServerErrorException) {
            logger.error("HTTP Server Error occurred in log flow", ex)
            "HTTP Server Error: ${ex.message}"
        }
    }

    @GetMapping("/log-http-client-error")
    fun logHttpClientErrorMessage(): String {
        logger.info("LogController: Invoking business HTTP client error service.")
        return try {
            businessHttpClientErrorService.processHttpClientError()
        } catch (ex: org.springframework.web.client.HttpClientErrorException) {
            logger.error("HTTP Client Error occurred in log flow", ex)
            "HTTP Client Error: ${ex.message}"
        }
    }

    @GetMapping("/log-bean-creation-error")
    fun logBeanCreationErrorMessage(): String {
        logger.info("LogController: Invoking business bean creation error service.")
        return try {
            businessBeanCreationService.processBeanCreation()
        } catch (ex: org.springframework.beans.factory.BeanCreationException) {
            logger.error("Bean Creation Error occurred in log flow", ex)
            "Bean Creation Error: ${ex.message}"
        }
    }

    @GetMapping("/log-no-such-bean-definition-error")
    fun logNoSuchBeanDefinitionErrorMessage(): String {
        logger.info("LogController: Invoking business no such bean definition error service.")
        return try {
            businessNoSuchBeanDefinitionService.processNoSuchBeanDefinition()
        } catch (ex: org.springframework.beans.factory.NoSuchBeanDefinitionException) {
            logger.error("No Such Bean Definition Error occurred in log flow", ex)
            "No Such Bean Definition Error: ${ex.message}"
        }
    }

    @GetMapping("/log-random-errors")
    fun logRandomErrors(@RequestParam(name = "count", required = false, defaultValue = "3") count: Int): String {
        logger.info("LogController: Generating $count random errors.")
        val errorTypes = listOf(
            { try { businessService.process() } catch (ex: Exception) { logger.error("DB Error", ex) } },
            { try { businessApiService.processApi() } catch (ex: Exception) { logger.error("API Error", ex) } },
            { try { businessRuntimeService.processRuntime() } catch (ex: Exception) { logger.error("Runtime Error", ex) } },
            { try { businessMemoryService.processMemory() } catch (ex: OutOfMemoryError) { logger.error("Memory Error", ex) } },
            { try { businessNullService.processNull() } catch (ex: NullPointerException) { logger.error("Null Pointer Error", ex) } },
            { try { businessIllegalArgumentService.processIllegalArgument() } catch (ex: IllegalArgumentException) { logger.error("Illegal Argument Error", ex) } },
            { try { businessArithmeticService.processArithmetic() } catch (ex: ArithmeticException) { logger.error("Arithmetic Error", ex) } },
            { try { businessIndexOutOfBoundsService.processIndexOutOfBounds() } catch (ex: IndexOutOfBoundsException) { logger.error("Index Out Of Bounds Error", ex) } },
            { try { businessHttpServerErrorService.processHttpServerError() } catch (ex: org.springframework.web.client.HttpServerErrorException) { logger.error("HTTP Server Error", ex) } },
            { try { businessHttpClientErrorService.processHttpClientError() } catch (ex: org.springframework.web.client.HttpClientErrorException) { logger.error("HTTP Client Error", ex) } },
            { try { businessBeanCreationService.processBeanCreation() } catch (ex: org.springframework.beans.factory.BeanCreationException) { logger.error("Bean Creation Error", ex) } },
            { try { businessNoSuchBeanDefinitionService.processNoSuchBeanDefinition() } catch (ex: org.springframework.beans.factory.NoSuchBeanDefinitionException) { logger.error("No Such Bean Definition Error", ex) } }
        )
        repeat(count) {
            val idx = Random.nextInt(errorTypes.size)
            errorTypes[idx]()
        }
        return "Generated $count random errors. Check logs for details."
    }
}
