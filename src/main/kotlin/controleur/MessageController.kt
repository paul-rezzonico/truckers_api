package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.service.ServiceMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(private val servicesMessage: ServiceMessage) {

    @GetMapping("/check")
    fun recupererToutLesMessages(): List<Destinataire> = servicesMessage.recupererToutLesMessages()

    @GetMapping("/check/{id}")
    fun recupererMessagesParId(@PathVariable id: String): List<Message> = servicesMessage.recupererMessageParId(id)

    @PostMapping("/sync")
    fun creerNumeroDeTelephone(@RequestBody payload: Destinataire): String {
        servicesMessage.mettreAJourMessage(payload.idTelephone, payload.messages)
        return "Messages sauvegardés sur le serveur"
    }
}
