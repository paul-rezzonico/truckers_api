package com.uniLim.info.repository

import com.uniLim.info.dataProvider.JsonDataProvider
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageRepository : IMessageRepository {

    @Autowired
    val JsonDataProvider: JsonDataProvider? = null
    override fun recupererTout(): List<Destinataire> {
        return JsonDataProvider!!.getData("Messages.json")
    }

    override fun recupererTouteLesErreurs(): List<Destinataire> {
        return JsonDataProvider!!.getData("Erreurs.json")
    }

    override fun recupererParId(id: String): List<Message> {
        return JsonDataProvider!!.getData("Messages.json").find { it.idTelephone == id }!!.messages
    }

    override fun mettreAJour(destinataire: String, messages: List<Message>): Boolean {
        return JsonDataProvider!!.addData(destinataire, messages, "Messages.json")
    }

    override fun mettreAJourErreurs(destinataire: String, messages: List<Message>): Boolean {
        return JsonDataProvider!!.addData(destinataire, messages, "Erreurs.json")
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