package com.example.logexporter.deal

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class VehicleService(private val restTemplate: RestTemplate) {
    fun getVehicle(dealId: String, simulateError: Boolean = false): String? {
        return restTemplate.getForObject("http://localhost:8083/vehicle?dealId=$dealId&simulateError=$simulateError", String::class.java)
    }
}
