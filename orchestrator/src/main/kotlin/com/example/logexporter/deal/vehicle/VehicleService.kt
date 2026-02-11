package com.example.logexporter.deal.vehicle

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class VehicleService(private val mapper: VehicleMapper) {
    private val logger = LoggerFactory.getLogger(VehicleService::class.java)
    fun getVehicle(dealId: String): VehicleDto {
        logger.info("VehicleService: Fetching vehicle for dealId: $dealId")
        return mapper.toDto(dealId)
    }
}
