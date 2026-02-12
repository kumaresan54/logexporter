package com.example.vehicle.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// VehicleModel enum to represent supported models
enum class VehicleModel {
    AMG, GCLASS, CLE, BCLASS, SCLASS, ECLASS, ACLASS, GLB, GLE, GLS
}

@RestController
@RequestMapping
class VehicleController(private val vehicleService: VehicleService) {
    private val logger = LoggerFactory.getLogger(VehicleController::class.java)

    @GetMapping("/vehicle")
    fun getVehicle(
        @RequestParam dealId: String,
        @RequestParam model: String
    ): ResponseEntity<Any> {
        logger.info("VehicleController: Received vehicle request for dealId: $dealId, model: $model")
        val allowedModels = VehicleModel.values().map { it.name }
        val vehicleModel = try {
            VehicleModel.valueOf(model.uppercase())
        } catch (e: IllegalArgumentException) {
            logger.warn("VehicleController: Invalid model '$model' for dealId: $dealId")
            return ResponseEntity.badRequest().body(mapOf(
                "error" to "Invalid vehicle model: $model",
                "allowedModels" to allowedModels
            ))
        }
        val result = vehicleService.getVehicleWithBusinessLogic(dealId, vehicleModel)
        if (result is String) {
            logger.warn("VehicleController: $result for dealId: $dealId, model: $model")
            return ResponseEntity.badRequest().body(result)
        }
        return ResponseEntity.ok(mapOf(
            "vehicle" to result,
            "allowedModels" to allowedModels
        ))
    }
}
