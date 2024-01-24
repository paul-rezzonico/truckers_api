package com.uniLim.info.repository

import com.uniLim.info.dataProvider.JsonDataProvider
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class MessageRepository : IMessageRepository {

    @Autowired
    val jsonDataProvider: JsonDataProvider? = null
    override fun recupererTout(): List<Destinataire> {
        return jsonDataProvider!!.getData("Messages-${LocalDate.now()}.json")
    }

    override fun recupererTouteLesErreurs(): List<Destinataire> {
        return jsonDataProvider!!.getData("Erreurs-${LocalDate.now()}.json")
    }
    override fun recupererParId(id: String): List<Message> {
        return jsonDataProvider!!.getData("Messages-${LocalDate.now()}.json")
            .find { it.idTelephone == id }?.messages
            ?: throw NoSuchElementException("Aucun message trouvé pour l'id $id")
    }

    override fun recupererErreurParId(id: String): List<Message> {
        return jsonDataProvider!!.getData("Erreurs-${LocalDate.now()}.json")
            .find { it.idTelephone == id }?.messages
            ?: throw NoSuchElementException("Aucun message en erreur trouvé pour l'id $id")
    }

    override fun recupererParDate(date: String): List<Destinataire> {
        return jsonDataProvider!!.getData("Messages-${date}.json")
    }

    override fun recupererErreursParDate(date: String): List<Destinataire> {
        return jsonDataProvider!!.getData("Erreurs-${date}.json")
    }

    override fun mettreAJour(destinataire: String, messages: List<Message>): Boolean {
        return jsonDataProvider!!.addData(destinataire, messages, "Messages-${LocalDate.now()}.json")
    }

    override fun mettreAJourErreurs(destinataire: String, messages: List<Message>): Boolean {
        return jsonDataProvider!!.addData(destinataire, messages, "Erreurs-${LocalDate.now()}.json")
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