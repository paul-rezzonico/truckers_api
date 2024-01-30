package com.uniLim.info.repository

import com.uniLim.info.dataProvider.JsonDataProvider
import com.uniLim.info.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class MessageRepository : IMessageRepository {

    @Autowired
    val jsonDataProvider: JsonDataProvider? = null

    override fun recupererParId(id: String): List<Message> {
        return jsonDataProvider!!.getData("Messages-${LocalDate.now()}-$id.json")
            .let { destinataire ->
                destinataire?.messages
                    ?: throw NoSuchElementException("Aucun message trouvé pour l'id $id") }
    }

    override fun recupererErreurParId(id: String): List<Message> {
        return jsonDataProvider!!.getData("Erreurs-${LocalDate.now()}-$id.json")
            .let { destinataire ->
                destinataire?.messages
                    ?: throw NoSuchElementException("Aucun message trouvé pour l'id $id") }
    }

    override fun mettreAJour(destinataire: String, messages: List<Message>): Boolean {
        return jsonDataProvider!!.addData(destinataire, messages, "Messages-${LocalDate.now()}-$destinataire.json")
    }

    override fun mettreAJourErreurs(destinataire: String, messages: List<Message>): Boolean {
        return jsonDataProvider!!.addData(destinataire, messages, "Erreurs-${LocalDate.now()}-$destinataire.json")
    }

    override fun supprimerParNumero(id: Long) {
        TODO("Not yet implemented")
    }

    override fun supprimerTout() {
        TODO("Not yet implemented")
    }
}