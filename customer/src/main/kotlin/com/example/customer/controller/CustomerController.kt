package com.example.customer.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping
class CustomerController(private val customerService: CustomerService) {
    private val logger = LoggerFactory.getLogger(CustomerController::class.java)

    @GetMapping("/customer")
    fun getCustomer(
        @RequestParam dealId: String,
        @RequestParam(required = false, defaultValue = "false") simulateError: Boolean
    ): ResponseEntity<Any> {
        logger.info("CustomerController: Received customer request for dealId: $dealId, simulateError: $simulateError")
        if (simulateError) {
            val errors = listOf(
                "Customer not found",
                "External service failure",
                "Missing permission to access customer"
            )
            val error = errors[Random.nextInt(errors.size)]
            logger.warn("CustomerController: $error for dealId: $dealId")
            return ResponseEntity.internalServerError().body(mapOf("error" to error))
        }
        return ResponseEntity.ok(customerService.getCustomer(dealId))
    }
}
