package com.example.logexporter.deal.pricing

import org.springframework.stereotype.Component

@Component
class PricingMapper {
    fun toDto(dealId: String): PricingDto = PricingDto(dealId, price = 99999.0)
}
