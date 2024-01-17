package com.paulrezzonico.service

import com.paulrezzonico.Modele.NumeroDeTelephone
import com.paulrezzonico.exception.NumeroInexistantException
import com.paulrezzonico.repository.INumeroDeTelephone
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ServiceNumeroDeTelephone(private val numeroDeTelephoneRepository: INumeroDeTelephone) {
    fun getAllEmployees(): List<NumeroDeTelephone> = numeroDeTelephoneRepository.findAll()

    fun getEmployeesById(employeeId: Long): NumeroDeTelephone = numeroDeTelephoneRepository.findById(employeeId)
            .orElseThrow { NumeroInexistantException(HttpStatus.NOT_FOUND, "Pas de numero de telephone correspondant") }

    fun createEmployee(employee: NumeroDeTelephone): NumeroDeTelephone = numeroDeTelephoneRepository.save(employee)

    fun updateEmployeeById(employeeId: Long, employee: NumeroDeTelephone): NumeroDeTelephone {
        return if (numeroDeTelephoneRepository.existsById(employeeId)) {
            numeroDeTelephoneRepository.save(
                    NumeroDeTelephone(
                            numero = employee.numero
                    )
            )
        } else throw NumeroInexistantException(HttpStatus.NOT_FOUND, "Pas de numero de telephone correspondant")
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (numeroDeTelephoneRepository.existsById(employeeId)) {
            numeroDeTelephoneRepository.deleteById(employeeId)
        } else throw NumeroInexistantException(HttpStatus.NOT_FOUND, "Pas de numero de telephone correspondant")
    }
}
