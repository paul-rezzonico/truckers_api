package com.paulrezzonico.service

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.NumeroDeTelephone
import com.paulrezzonico.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(private val numeroDeTelephoneRepository: IMessageRepository) {
    fun recupererToutLesMessages(): List<Destinataire> = numeroDeTelephoneRepository.recupererTout()

    fun getEmployeesById(employeeId: Long) {

    }

    fun createEmployee(employee: NumeroDeTelephone){

    }

    fun updateEmployeeById(employeeId: Long, employee: NumeroDeTelephone) {

    }

    fun deleteEmployeesById(employeeId: Long) {

    }
}
