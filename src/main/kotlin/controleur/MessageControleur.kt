package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.NumeroEtMessages
import com.uniLim.info.service.ServiceMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageControleur(private val servicesMessage: ServiceMessage) {

    @GetMapping("/check_msg")
    fun recupererToutLesMessages(): List<Destinataire> = servicesMessage.recupererToutLesMessages()

    @GetMapping("/check_err")
    fun recupererToutLesMessagesEnErreur(): List<Destinataire> = servicesMessage.recupererToutLesMessagesEnErreur()

    @PostMapping("/sync_msg")
    fun creerNumeroDeTelephone(@RequestBody payload: NumeroEtMessages): String {
        servicesMessage.mettreAJourMessage(payload.numero, payload.messages)
        return "Messages sauvegardés sur le serveur"
    }

    @PostMapping("/sync_err")
    fun creerNumeroDeTelephoneEnErreur(@RequestBody payload: NumeroEtMessages): String {
        servicesMessage.mettreAJourMessageEnErreur(payload.numero, payload.messages)
        return "Messages en erreur sauvegardés sur le serveur"
    }
}
