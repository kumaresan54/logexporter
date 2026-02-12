package com.example.customer.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomerService(private val mapper: CustomerMapper) {
    private val logger = LoggerFactory.getLogger(CustomerService::class.java)
    fun getCustomer(dealId: String): CustomerDto {
        logger.info("CustomerService: Fetching customer for dealId: $dealId")
        return mapper.toDto(dealId)
    }

    fun getCustomerWithModelValidation(dealId: String, model: String): Any {
        val allowedModels = VehicleModel.entries.map { it.name }
        val vehicleModel = try {
            VehicleModel.valueOf(model.uppercase())
        } catch (e: IllegalArgumentException) {
            logger.warn("Customer service: Invalid model '$model' for dealId: $dealId")
            return "Invalid model: $model, allowedModels are $allowedModels"
        }

        val response = when (vehicleModel) {
            VehicleModel.AMG -> getCustomer(dealId)
            VehicleModel.GCLASS ->  getCustomer(dealId)
            VehicleModel.CLE ->  getCustomer(dealId)
            VehicleModel.BCLASS -> getCustomer(dealId)
            VehicleModel.SCLASS -> getCustomer(dealId)
            VehicleModel.ECLASS ->  getCustomer(dealId)
            VehicleModel.ACLASS ->  getCustomer(dealId)
            VehicleModel.GLB ->  getCustomer(dealId)
            VehicleModel.GLE -> "GLE access error: Customer profile incomplete for GLE access."
            VehicleModel.GLS -> "GLS not available: GLS model is not available for this customer tier."
        }
        return response
    }

    enum class VehicleModel {
        AMG, GCLASS, CLE, BCLASS, SCLASS, ECLASS, ACLASS, GLB, GLE, GLS
    }
}
