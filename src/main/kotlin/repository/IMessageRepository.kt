package com.uniLim.info.repository

import com.uniLim.info.model.Message

interface IMessageRepository {

    fun getByPhoneId(id: String): List<Message>

    fun getErrorByPhoneId(id: String): List<Message>

    fun update(destinataire: String, messages: List<Message>): Int

    fun updateError(destinataire: String, messages: List<Message>): Int

    fun deleteByPhone(id: Long)

    fun deleteAll()
}
