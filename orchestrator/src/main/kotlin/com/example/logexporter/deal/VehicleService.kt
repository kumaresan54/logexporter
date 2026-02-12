package com.example.logexporter.deal

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class VehicleService(private val restTemplate: RestTemplate) {

    fun getVehicleWithBusinessLogic(dealId: String, model: String): String? {
        return restTemplate.getForObject("http://localhost:8083/vehicle?dealId=$dealId&model=$model", String::class.java)
    }
}
