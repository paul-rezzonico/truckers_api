package com.uniLim.info.service

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(private val repository: IMessageRepository) {

    fun recupererMessageParId(id: String): List<Message> = repository.recupererParId(id)

    fun mettreAJourMessage(idDestinataire: String, messages: List<Message>): Boolean = repository.mettreAJour(idDestinataire, messages)
}
