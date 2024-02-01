package com.uniLim.info.service

import com.uniLim.info.model.Message
import com.uniLim.info.repository.IMessageRepository
import org.springframework.stereotype.Service

@Service
class ErrorMessagesService(private val repository: IMessageRepository) {

    fun recupererMessageEnErreurParId(id: String) = repository.getErrorByPhoneId(id)

    fun mettreAJourMessageEnErreur(destinataire: String, messages: List<Message>): Int = repository.updateError(destinataire, messages)

}