package com.paulrezzonico.service

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.Message
import com.paulrezzonico.model.NumeroDeTelephone
import com.paulrezzonico.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(private val numeroDeTelephoneRepository: IMessageRepository) {
    fun recupererToutLesMessages(): List<Destinataire> = numeroDeTelephoneRepository.recupererTout()

    fun recupererMessageParId(id: Long) {

    }

    fun mettreAJourMessage(destinataire: NumeroDeTelephone, messages: List<Message>): Boolean = numeroDeTelephoneRepository.mettreAJour(destinataire, messages)
}
