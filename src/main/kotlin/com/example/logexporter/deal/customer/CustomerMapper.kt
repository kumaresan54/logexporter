package com.example.logexporter.deal.customer

import org.springframework.stereotype.Component

@Component
class CustomerMapper {
    fun toDto(dealId: String): CustomerDto = CustomerDto(dealId, customerId = "C456", name = "John Doe")
}
