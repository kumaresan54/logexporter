package com.example.vehicle.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping
class VehicleController(private val vehicleService: VehicleService) {
    private val logger = LoggerFactory.getLogger(VehicleController::class.java)

    @GetMapping("/vehicle")
    fun getVehicle(
        @RequestParam dealId: String,
        @RequestParam(required = false, defaultValue = "false") simulateError: Boolean
    ): ResponseEntity<Any> {
        logger.info("VehicleController: Received vehicle request for dealId: $dealId, simulateError: $simulateError")
        if (simulateError) {
            val errors = listOf(
                "Vehicle not found",
                "DB failure",
                "External service failure"
            )
            val error = errors[Random.nextInt(errors.size)]
            logger.warn("VehicleController: $error for dealId: $dealId")
            return ResponseEntity.internalServerError().body(mapOf("error" to error))
        }
        return ResponseEntity.ok(vehicleService.getVehicle(dealId))
    }
}
