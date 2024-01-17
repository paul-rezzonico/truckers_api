package com.paulrezzonico.controller

import com.paulrezzonico.Modele.NumeroDeTelephone
import com.paulrezzonico.service.ServiceNumeroDeTelephone
import org.springframework.web.bind.annotation.*

@RestController
class NumeroDeTelephoneController(private val servicesNumeroDeTelephone: ServiceNumeroDeTelephone) {

    @GetMapping("/numeroDeTelephone")
    fun recupererToutLesNumeroDeTelephones(): List<NumeroDeTelephone> = servicesNumeroDeTelephone.getAllEmployees()

    @PostMapping("/numeroDeTelephone")
    fun creerNumeroDeTelephone(@RequestBody payload: NumeroDeTelephone): NumeroDeTelephone = servicesNumeroDeTelephone.createEmployee(payload)

}
