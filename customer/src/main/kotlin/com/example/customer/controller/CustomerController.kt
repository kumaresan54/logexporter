package com.example.customer.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class CustomerController(private val customerService: CustomerService) {
    private val logger = LoggerFactory.getLogger(CustomerController::class.java)

    @GetMapping("/customer")
    fun getCustomer(
        @RequestParam dealId: String,
        @RequestParam model: String
    ): ResponseEntity<Any> {
        logger.info("CustomerController: Received customer request for dealId: $dealId, model: $model")
        val result = customerService.getCustomerWithModelValidation(dealId, model)
        if (result is String) {
            logger.warn("CustomerController: $result for dealId: $dealId, model: $model")
            return ResponseEntity.internalServerError().body(result)
        }
        return ResponseEntity.ok(result)
    }
}
