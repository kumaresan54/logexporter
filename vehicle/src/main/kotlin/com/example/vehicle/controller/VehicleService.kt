package com.example.vehicle.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class VehicleService(private val mapper: VehicleMapper) {
    private val logger = LoggerFactory.getLogger(VehicleService::class.java)
    fun getVehicle(dealId: String): VehicleDto {
        logger.info("VehicleService: Fetching vehicle for dealId: $dealId")
        return mapper.toDto(dealId)
    }

    fun getVehicleWithBusinessLogic(dealId: String, model: VehicleModel): Any {
        logger.info("VehicleService: Fetching vehicle for dealId: $dealId, model: $model")

        val response = when (model) {
            VehicleModel.AMG -> getVehicle(dealId)
            VehicleModel.GCLASS -> "G-Class not available: The Mercedes-Benz G-Class is not available in our inventory at the moment. Contact your dealer for future availability."
            VehicleModel.CLE -> "CLE maintenance: The Mercedes-Benz CLE is undergoing scheduled maintenance and cannot be processed for new deals right now."
            VehicleModel.BCLASS -> "B-Class discontinued: The Mercedes-Benz B-Class has been discontinued and is no longer offered for new deals."
            VehicleModel.SCLASS -> "S-Class recall: The Mercedes-Benz S-Class has an active recall. Please resolve recall issues before proceeding."
            VehicleModel.ECLASS -> "E-Class registration expired: The Mercedes-Benz E-Class registration has expired. Please renew registration before continuing."
            VehicleModel.ACLASS -> "A-Class insurance invalid: The Mercedes-Benz A-Class does not have valid insurance coverage. Update insurance details to proceed."
            VehicleModel.GLB -> "GLB emission issue: The Mercedes-Benz GLB does not meet current emission standards and cannot be processed."
            VehicleModel.GLE -> "GLE warranty expired: The Mercedes-Benz GLE warranty has expired. Contact support for assistance."
            VehicleModel.GLS -> "GLS parts unavailable: Replacement parts for the Mercedes-Benz GLS are currently unavailable. Please try again later."
        }

        return response
    }
}
