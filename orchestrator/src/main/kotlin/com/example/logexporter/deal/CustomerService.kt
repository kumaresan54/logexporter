package com.example.logexporter.deal

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerService(private val restTemplate: RestTemplate) {
    fun getCustomer(dealId: String, model: String): String? {
        return restTemplate.getForObject("http://localhost:8081/customer?dealId=$dealId&model=$model", String::class.java)
    }
}
