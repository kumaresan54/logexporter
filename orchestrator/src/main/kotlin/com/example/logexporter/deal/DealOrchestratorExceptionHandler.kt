package com.example.logexporter.deal

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class DealOrchestratorExceptionHandler {
    private val logger = LoggerFactory.getLogger(DealOrchestratorExceptionHandler::class.java)

    @ExceptionHandler(HttpClientErrorException::class)
    fun handleHttpClientErrorException(ex: HttpClientErrorException): ResponseEntity<Map<String, String>> {
        logger.error("DealOrchestratorController: Service call failed: ${ex.message}")
        return ResponseEntity.status(424).body(mapOf("error" to (ex.message ?: "Service dependency failed")))
    }

    @ExceptionHandler(HttpServerErrorException::class)
    fun handleHttpServerErrorException(ex: HttpServerErrorException): ResponseEntity<Map<String, String>> {
        logger.error("DealOrchestratorController: Service call failed: ${ex.message}")
        return ResponseEntity.status(500).body(mapOf("error" to (ex.message ?: "Service call failed")))
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<Map<String, String>> {
        logger.error("DealOrchestratorController: Unexpected error: ${ex.message}", ex)
        return ResponseEntity.internalServerError().body(mapOf("error" to (ex.message ?: "Unexpected error occurred")))
    }
}
