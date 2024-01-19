package com.paulrezzonico.controleur

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.NumeroEtMessages
import com.paulrezzonico.service.ServiceMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageControleur(private val servicesMessage: ServiceMessage) {

    @GetMapping("/check_msg")
    fun recupererToutLesMessages(): List<Destinataire> = servicesMessage.recupererToutLesMessages()

    @PostMapping("/sync_msg")
    fun creerNumeroDeTelephone(@RequestBody payload: NumeroEtMessages): String {
        servicesMessage.mettreAJourMessage(payload.numero, payload.messages)
        return "Messages sauvegardés sur le serveur"
    }
}
