package com.paulrezzonico.repository

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.Message

interface IMessageRepository {
    fun recupererTout(): List<Destinataire>
    fun trouverParNumero(id: Long): List<Message>

    fun sauvegarder(message: Message): Message

    fun supprimerParNumero(id: Long)

    fun supprimerTout()

    fun conter(): Long
}
