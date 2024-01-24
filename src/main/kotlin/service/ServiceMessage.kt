package com.uniLim.info.service

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(private val numeroDeTelephoneRepository: IMessageRepository) {
    fun recupererToutLesMessages(): List<Destinataire> = numeroDeTelephoneRepository.recupererTout()

    fun recupererMessageParId(id: String) = numeroDeTelephoneRepository.recupererParId(id)

    fun mettreAJourMessage(destinataire: String, messages: List<Message>): Boolean = numeroDeTelephoneRepository.mettreAJour(destinataire, messages)
}
