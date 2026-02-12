package com.example.pricing.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping
class PricingController(private val pricingService: PricingService) {
    private val logger = LoggerFactory.getLogger(PricingController::class.java)

    @GetMapping("/pricing")
    fun getPricing(
        @RequestParam dealId: String,
        @RequestParam model: String
    ): ResponseEntity<Any> {
        logger.info("PricingController: Received pricing request for dealId: $dealId, model: $model")
        val result = pricingService.getPricingWithModelValidation(dealId, model)
        if (result is String) {
            logger.warn("PricingController: $result for dealId: $dealId, model: $model")
            return ResponseEntity.internalServerError().body(result)
        }

        return ResponseEntity.ok(result)
    }

    @GetMapping("/pricingInfo")
    fun getPricingInfo(
        @RequestParam dealId: String,
        @RequestParam(required = false, defaultValue = "false") simulateError: Boolean
    ): ResponseEntity<Any> {
       if (dealId=="852")
           return ResponseEntity.notFound().build()

        return ResponseEntity.ok(pricingService.getPricing(dealId))
    }
}
