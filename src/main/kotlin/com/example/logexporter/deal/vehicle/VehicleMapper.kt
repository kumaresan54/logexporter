package com.example.logexporter.deal.vehicle

import org.springframework.stereotype.Component

@Component
class VehicleMapper {
    fun toDto(dealId: String): VehicleDto = VehicleDto(dealId, vehicleId = "V123", model = "Sedan")
}
