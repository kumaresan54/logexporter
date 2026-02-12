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
