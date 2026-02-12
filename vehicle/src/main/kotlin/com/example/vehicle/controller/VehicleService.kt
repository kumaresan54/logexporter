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
            VehicleModel.GCLASS -> getVehicle(dealId)
            VehicleModel.BMW -> "Maintenance required"
            VehicleModel.AUDI -> "Recall issued"
            VehicleModel.TESLA -> "Registration expired"
            VehicleModel.HONDA -> "Insurance not valid"
            VehicleModel.TOYOTA -> "Model discontinued"
            VehicleModel.FORD -> "Emission standards not met"
            VehicleModel.CHEVROLET -> "Warranty expired"
            VehicleModel.NISSAN -> "Parts unavailable"
            else -> "Invalid vehicle"
        }

        return response
    }
}
