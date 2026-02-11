package com.example.logexporter.deal.customer

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomerService(private val mapper: CustomerMapper) {
    private val logger = LoggerFactory.getLogger(CustomerService::class.java)
    fun getCustomer(dealId: String): CustomerDto {
        logger.info("CustomerService: Fetching customer for dealId: $dealId")
        return mapper.toDto(dealId)
    }
}
