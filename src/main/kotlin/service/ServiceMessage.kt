package com.uniLim.info.service

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(private val numeroDeTelephoneRepository: IMessageRepository) {
    fun recupererToutLesMessages(): List<Destinataire> = numeroDeTelephoneRepository.recupererTout()

    fun recupererToutLesMessagesEnErreur(): List<Destinataire> = numeroDeTelephoneRepository.recupererTouteLesErreurs()

    fun recupererMessageParId(id: Long) {

    }

    fun mettreAJourMessage(destinataire: String, messages: List<Message>): Boolean = numeroDeTelephoneRepository.mettreAJour(destinataire, messages)

    fun mettreAJourMessageEnErreur(destinataire: String, messages: List<Message>): Boolean = numeroDeTelephoneRepository.mettreAJourErreurs(destinataire, messages)
}
