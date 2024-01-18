package com.paulrezzonico.repository

import com.paulrezzonico.dataProvider.JsonDataProvider
import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageRepository : IMessageRepository {

    @Autowired
    val JsonDataProvider: JsonDataProvider? = null
    override fun recupererTout(): List<Destinataire> {
        return JsonDataProvider!!.getData()
    }

    override fun trouverParNumero(id: Long): List<Message> {
        TODO("Not yet implemented")
    }

    override fun sauvegarder(message: Message): Message {
        TODO("Not yet implemented")
    }

    override fun supprimerParNumero(id: Long) {
        TODO("Not yet implemented")
    }

    override fun supprimerTout() {
        TODO("Not yet implemented")
    }

    override fun conter(): Long {
        TODO("Not yet implemented")
    }

}