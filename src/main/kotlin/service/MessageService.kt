package com.uniLim.info.service

import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(private val repository: IMessageRepository) {

    fun recupererMessageParId(id: String): List<Message> = repository.getByPhoneId(id)

    fun mettreAJourMessage(idDestinataire: String, messages: List<Message>): Int = repository.update(idDestinataire, messages)
}
