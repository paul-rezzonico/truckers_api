package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.service.ServiceMessageEnErreur
import org.springframework.web.bind.annotation.*

@RestController
class MessageErreurController(private val servicesMessage: ServiceMessageEnErreur) {

    @GetMapping("/check_err")
    fun recupererToutLesMessagesEnErreur(): List<Destinataire> = servicesMessage.recupererToutLesMessagesEnErreur()

    @GetMapping("/check_err/{id}")
    fun recupererMessagesParId(@PathVariable id: String): List<Message> = servicesMessage.recupererMessageEnErreurParId(id)

    @PostMapping("/sync_err")
    fun creerNumeroDeTelephoneEnErreur(@RequestBody payload: Destinataire): String {
        servicesMessage.mettreAJourMessageEnErreur(payload.idTelephone, payload.messages)
        return "Messages en erreur sauvegardés sur le serveur"
    }
}