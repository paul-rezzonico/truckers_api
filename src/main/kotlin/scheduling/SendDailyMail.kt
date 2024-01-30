package com.uniLim.info.scheduling

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import service.EmailService


@Component
class SendDailyMail {

    @Autowired
    private val emailService: EmailService? = null

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    fun sendDailyMail() {
        emailService!!.sendSimpleMessage(
            to = "paul.rezzonico@etu.unilim.fr",
            subject = "Messages reçus",
            text = ""
        )
    }
}