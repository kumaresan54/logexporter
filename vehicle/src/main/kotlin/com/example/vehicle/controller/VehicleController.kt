package com.example.vehicle.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class VehicleController(private val vehicleService: VehicleService) {
    private val logger = LoggerFactory.getLogger(VehicleController::class.java)

    @GetMapping("/vehicle")
    fun getVehicle(@RequestParam dealId: String): VehicleDto {
        logger.info("VehicleController: Received vehicle request for dealId: $dealId")
        return vehicleService.getVehicle(dealId)
    }
}
