package com.uniLim.info.repository

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone

interface IMessageRepository {
    fun recupererTout(): List<Destinataire>

    fun recupererTouteLesErreurs(): List<Destinataire>
    fun trouverParNumero(id: Long): List<Message>

    fun mettreAJour(destinataire: NumeroDeTelephone, messages: List<Message>): Boolean

    fun mettreAJourErreurs(destinataire: NumeroDeTelephone, messages: List<Message>): Boolean

    fun supprimerParNumero(id: Long)

    fun supprimerTout()

    fun conter(): Long
}
