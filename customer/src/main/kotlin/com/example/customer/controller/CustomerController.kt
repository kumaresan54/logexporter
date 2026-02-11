package com.example.customer.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerService: CustomerService) {
    private val logger = LoggerFactory.getLogger(CustomerController::class.java)

    @GetMapping("/customer")
    fun getCustomer(@RequestParam dealId: String): CustomerDto {
        logger.info("CustomerController: Received customer request for dealId: $dealId")
        return customerService.getCustomer(dealId)
    }
}
