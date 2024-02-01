package com.uniLim.info.controleur

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.service.ErrorMessagesService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages_err")
class MessageErrorController(private val servicesMessage: ErrorMessagesService) {

    @GetMapping("/{id}")
    fun getBypPhoneId(@PathVariable id: String): List<Message> = servicesMessage.getErrorByPhoneId(id)

    @PostMapping("/sync")
    fun synchronizeMessages(@RequestBody payload: Destinataire): Int {
        return servicesMessage.updateError(payload.idTelephone, payload.messages)
    }
}