package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.service.ServiceMessageEnErreur
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages_err")
class MessageErreurController(private val servicesMessage: ServiceMessageEnErreur) {

    @GetMapping("/")
    fun recupererToutLesMessagesEnErreur(): List<Destinataire> = servicesMessage.recupererToutLesMessagesEnErreur()

    @GetMapping("/{id}")
    fun recupererMessagesParId(@PathVariable id: String): List<Message> = servicesMessage.recupererMessageEnErreurParId(id)

    @GetMapping("/date/{date}")
    fun recupererMessageParDate(@PathVariable date: String): List<Destinataire> = servicesMessage.recupererMessageEnErreurParDate(date)

    @PostMapping("/sync")
    fun creerNumeroDeTelephoneEnErreur(@RequestBody payload: Destinataire): String {
        servicesMessage.mettreAJourMessageEnErreur(payload.idTelephone, payload.messages)
        return "Messages en erreur sauvegardés sur le serveur"
    }
}