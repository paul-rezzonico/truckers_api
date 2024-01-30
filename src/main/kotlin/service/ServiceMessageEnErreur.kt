package com.uniLim.info.service

import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessageEnErreur(private val repository: IMessageRepository) {

    fun recupererMessageEnErreurParId(id: String) = repository.recupererErreurParId(id)

    fun mettreAJourMessageEnErreur(destinataire: String, messages: List<Message>): Boolean = repository.mettreAJourErreurs(destinataire, messages)

}