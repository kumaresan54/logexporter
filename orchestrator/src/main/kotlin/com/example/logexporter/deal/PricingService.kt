package com.example.logexporter.deal

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PricingService(private val restTemplate: RestTemplate) {
    fun getPricing(dealId: String, simulateError: Boolean = false): String? {
        return restTemplate.getForObject("http://localhost:8082/pricing?dealId=$dealId&simulateError=$simulateError", String::class.java)
    }
}
