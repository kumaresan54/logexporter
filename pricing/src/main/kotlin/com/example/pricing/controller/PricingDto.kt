package com.example.pricing.controller
data class PricingDto(val dealId: String, val price: Double)
data class OrderSummary(
    val dealId: String,
    val total: Double,
    val discount: Boolean
)

