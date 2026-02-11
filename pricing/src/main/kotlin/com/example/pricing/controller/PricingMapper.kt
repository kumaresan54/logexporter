package com.example.pricing.controller

import org.springframework.stereotype.Component

@Component
class PricingMapper {
    fun toDto(dealId: String): PricingDto = PricingDto(dealId, price = 99999.0)
}
