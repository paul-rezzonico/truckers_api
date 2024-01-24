package com.uniLim.info.repository

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message

interface IMessageRepository {
    fun recupererTout(): List<Destinataire>

    fun recupererTouteLesErreurs(): List<Destinataire>
    fun recupererParId(id: String): List<Message>

    fun recupererErreurParId(id: String): List<Message>

    fun recupererParDate(date: String): List<Destinataire>

    fun recupererErreurParDate(): List<Message>

    fun mettreAJour(destinataire: String, messages: List<Message>): Boolean

    fun mettreAJourErreurs(destinataire: String, messages: List<Message>): Boolean

    fun supprimerParNumero(id: Long)

    fun supprimerTout()

    fun conter(): Long
}
