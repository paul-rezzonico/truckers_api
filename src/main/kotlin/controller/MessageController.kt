package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/messages")
class MessageController(private val servicesMessage: MessageService) {

    @GetMapping("/{id}")
    fun getByPhoneId(@PathVariable id: String): List<Message> = servicesMessage.getByPhoneId(id)

    @PostMapping("/sync")
    fun synchronizeMessages(@RequestBody payload: Destinataire): Int {
        return servicesMessage.update(payload.idTelephone, payload.messages)
    }
}
