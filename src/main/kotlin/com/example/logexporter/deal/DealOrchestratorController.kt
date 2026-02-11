package com.example.logexporter.deal

import com.example.logexporter.deal.pricing.PricingService
import com.example.logexporter.deal.vehicle.VehicleService
import com.example.logexporter.deal.customer.CustomerService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.Operation

@RestController
class DealOrchestratorController(
    private val pricingService: PricingService,
    private val vehicleService: VehicleService,
    private val customerService: CustomerService
) {
    private val logger = LoggerFactory.getLogger(DealOrchestratorController::class.java)

    @Operation(summary = "Orchestrate deal", description = "Invokes pricing, vehicle, and customer services and logs each step with dealId")
    @GetMapping("/deal/orchestrate")
    fun orchestrateDeal(@RequestParam dealId: String): String {
        logger.info("DealOrchestratorController: Starting deal orchestration for dealId: $dealId")
        val price = pricingService.getPricing(dealId)
        logger.info("DealOrchestratorController: Pricing fetched for dealId: $dealId: $price")
        val vehicle = vehicleService.getVehicle(dealId)
        logger.info("DealOrchestratorController: Vehicle fetched for dealId: $dealId: $vehicle")
        val customer = customerService.getCustomer(dealId)
        logger.info("DealOrchestratorController: Customer fetched for dealId: $dealId: $customer")
        logger.info("DealOrchestratorController: Deal is success for dealId: $dealId")
        return "Deal is success"
    }
}
