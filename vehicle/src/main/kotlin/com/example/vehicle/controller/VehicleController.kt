package com.example.vehicle.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// VehicleModel enum to represent supported models
enum class VehicleModel {
    AMG, GCLASS, BMW, AUDI, TESLA, HONDA, TOYOTA, FORD, CHEVROLET, NISSAN, OTHER
}

@RestController
@RequestMapping
class VehicleController(private val vehicleService: VehicleService) {
    private val logger = LoggerFactory.getLogger(VehicleController::class.java)

    @GetMapping("/vehicle")
    fun getVehicle(
        @RequestParam dealId: String,
        @RequestParam model: VehicleModel
    ): ResponseEntity<Any> {
        logger.info("VehicleController: Received vehicle request for dealId: $dealId, model: $model")
        val result = vehicleService.getVehicleWithBusinessLogic(dealId, model)
        if (result is String) {
            logger.warn("VehicleController: $result for dealId: $dealId, model: $model")
            return ResponseEntity.badRequest().body(result)
        }
        return ResponseEntity.ok(result)
    }
}
