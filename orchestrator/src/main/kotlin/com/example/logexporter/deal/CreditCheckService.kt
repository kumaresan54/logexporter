package com.example.logexporter.deal

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import kotlin.math.log

@Service
class CreditCheckService(private val restTemplate: RestTemplate)  {
    private val logger = LoggerFactory.getLogger(CreditCheckService::class.java)
    fun checkCredit():String? {
        val result =  restTemplate.getForObject("https://dummyjson.com/c/c26b-7647-4187-86e2", CreditCheckDTO::class.java)
        if(result?.creditCheck == "error")
            throw Exception("User Invalid for Credit Check")

        return result?.creditCheck
    }

}
