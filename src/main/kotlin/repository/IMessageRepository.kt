package com.uniLim.info.repository

import com.uniLim.info.model.Message

interface IMessageRepository {

    fun recupererParId(id: String): List<Message>

    fun recupererErreurParId(id: String): List<Message>

    fun mettreAJour(destinataire: String, messages: List<Message>): Boolean

    fun mettreAJourErreurs(destinataire: String, messages: List<Message>): Boolean

    fun supprimerParNumero(id: Long)

    fun supprimerTout()
}
