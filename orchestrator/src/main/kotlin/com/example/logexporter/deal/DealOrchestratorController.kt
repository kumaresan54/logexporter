package com.example.logexporter.deal

import io.swagger.v3.oas.annotations.Operation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class DealOrchestratorController @Autowired constructor(
    private val customerService: CustomerService,
    private val pricingService: PricingService,
    private val vehicleService: VehicleService,
    private val creditCheckService: CreditCheckService
) {
    private val logger = LoggerFactory.getLogger(DealOrchestratorController::class.java)

    @Operation(summary = "Orchestrate deal", description = "Invokes pricing, vehicle, and customer services via HTTP and logs each step with dealId. Optionally simulates business errors in one service.")
    @GetMapping("/deal/orchestrate")
    fun orchestrateDeal(
        @RequestParam dealId: String,
        @RequestParam(required = false, defaultValue = "AMG") model: VehicleModel
    ): String {
        logger.info("DealOrchestratorController: Starting deal orchestration for dealId: $dealId, model: $model")

        val customer = customerService.getCustomer(dealId, model.name)
        logger.info("DealOrchestratorController: Customer fetched for dealId: $dealId: $customer")

        val vehicle = vehicleService.getVehicleWithBusinessLogic(dealId, model.name)
        logger.info("DealOrchestratorController: Vehicle fetched for dealId: $dealId: $vehicle")

        val price = pricingService.getPricing(dealId, model.name)
        logger.info("DealOrchestratorController: Pricing fetched for dealId: $dealId: $price")

        logger.info("DealOrchestratorController: Deal is success for dealId: $dealId")
        return "Deal is success"
    }

    @Operation(summary = "Perform credit check", description = "Performs credit check for a customer and returns the result")
    @GetMapping("/credit/check")
    fun performCreditCheck(
        @RequestParam dealId: String,
    ): String {

        logger.info("CreditCheckController: Starting credit check for dealId: $dealId")
        return try {
            val customer = customerService.getCustomer(dealId)
            val pricing = pricingService.getPricingInfo(dealId)

            val creditResult = creditCheckService.checkCredit()
            logger.info("CreditCheckController: Credit check completed for dealId: $dealId, result: $creditResult")
            "Credit check ${if (creditResult == "APPROVED") "approved" else "denied"} for customer"
        } catch (e: Exception) {
            logger.error("CreditCheckController: Credit check failed for dealId: $dealId", e)
            "Credit check failed for customer"
        }
    }


}

enum class VehicleModel {
    AMG, GCLASS, CLE, BCLASS, SCLASS, ECLASS, ACLASS, GLB, GLE, GLS
}