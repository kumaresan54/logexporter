package com.example.pricing.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PricingService(private val mapper: PricingMapper) {
    private val logger = LoggerFactory.getLogger(PricingService::class.java)
    fun getPricing(dealId: String): PricingDto {
        logger.info("PricingService: Fetching price for dealId: $dealId")
        return mapper.toDto(dealId)
    }
}
