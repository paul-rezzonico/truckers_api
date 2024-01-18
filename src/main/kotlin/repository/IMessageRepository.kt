package com.paulrezzonico.repository

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.Message
import com.paulrezzonico.model.NumeroDeTelephone

interface IMessageRepository {
    fun recupererTout(): List<Destinataire>
    fun trouverParNumero(id: Long): List<Message>

    fun mettreAJour(destinataire: NumeroDeTelephone, messages: List<Message>): Boolean

    fun supprimerParNumero(id: Long)

    fun supprimerTout()

    fun conter(): Long
}
