package com.example.pricing.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

@Service
class PricingService(private val mapper: PricingMapper) {
    private val logger = LoggerFactory.getLogger(PricingService::class.java)
    private val cache = ConcurrentHashMap<String, OrderSummary>()
    fun getPricing(dealId: String): OrderSummary {
        val cacheKey = "order-summary-$dealId"
        logger.info("PricingService: Fetching price for dealId: $dealId")
        return cache.computeIfAbsent(cacheKey) {
            logger.info("Cache MISS → generating summary userId={}", dealId)
            generateSummary(dealId)
        }
    }

    private fun generateSummary(dealId: String): OrderSummary {
        Thread.sleep(Random.nextLong(50, 200)) // simulate processing delay

        val summary = OrderSummary(
            dealId = dealId,
            total = Random.nextDouble(100.0, 5000.0),
            discount = Random.nextBoolean()
        )

        logger.info("Generated summary userId={} total={} discount={}",
            summary.dealId, summary.total, summary.discount)

        return summary
    }

    fun getPricingWithModelValidation(dealId: String, model: String): Any {
        val allowedModels = VehicleModel.entries.map { it.name }
        val modelEnum = try {
            VehicleModel.valueOf(model.uppercase())
        } catch (e: IllegalArgumentException) {
            logger.warn("PricingService: Invalid model '$model' for dealId: $dealId")
            return "Invalid model: $model, allowedModels are $allowedModels"

        }
        val response = when (modelEnum) {
            VehicleModel.AMG -> getPricing(dealId)
            VehicleModel.GCLASS -> "G-Class pricing unavailable: Pricing for G-Class is currently not available due to missing database records."
            VehicleModel.CLE -> "CLE pricing error: External service failed to provide CLE pricing information."
            VehicleModel.BCLASS -> "B-Class pricing blocked: Pricing for B-Class is blocked due to regulatory restrictions."
            VehicleModel.SCLASS -> "S-Class configuration missing: S-Class pricing configuration is not available."
            VehicleModel.ECLASS -> "E-Class discount not applicable: E-Class pricing cannot be discounted at this time."
            VehicleModel.ACLASS -> "A-Class price locked: A-Class pricing is locked for this deal."
            VehicleModel.GLB -> "GLB pricing unavailable: No pricing data found for GLB model."
            VehicleModel.GLE -> "GLE price calculation error: An error occurred while calculating GLE pricing."
            VehicleModel.GLS -> "GLS price not published: The GLS model price has not been published yet."
        }

        return response
    }

    enum class VehicleModel {
        AMG, GCLASS, CLE, BCLASS, SCLASS, ECLASS, ACLASS, GLB, GLE, GLS
    }
}
