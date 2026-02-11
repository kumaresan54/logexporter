package com.example.pricing.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.slf4j.LoggerFactory

@RestController
class PricingController(private val pricingService: PricingService) {
    private val logger = LoggerFactory.getLogger(PricingController::class.java)

    @GetMapping("/pricing")
    fun getPricing(@RequestParam dealId: String): PricingDto {
        logger.info("PricingController: Received pricing request for dealId: $dealId")
        return pricingService.getPricing(dealId)
    }
}
