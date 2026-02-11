package com.example.pricing.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.slf4j.LoggerFactory
import kotlin.random.Random
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping
class PricingController(private val pricingService: PricingService) {
    private val logger = LoggerFactory.getLogger(PricingController::class.java)

    @GetMapping("/pricing")
    fun getPricing(
        @RequestParam dealId: String,
        @RequestParam(required = false, defaultValue = "false") simulateError: Boolean
    ): ResponseEntity<Any> {
        logger.info("PricingController: Received pricing request for dealId: $dealId, simulateError: $simulateError")
        if (simulateError) {
            val errors = listOf(
                "Pricing not found",
                "No Configuration available",
                "External service failure"
            )
            val error = errors[Random.nextInt(errors.size)]
            logger.warn("PricingController: $error for dealId: $dealId")
            return ResponseEntity.internalServerError().body(mapOf("error" to error))
        }
        return ResponseEntity.ok(pricingService.getPricing(dealId))
    }
}
