package com.uniLim.info.scheduling

import com.uniLim.info.utils.Zipper
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import service.EmailService


@Component
class SendDailyMail {

    @Autowired
    private val emailService: EmailService? = null

    @Autowired
    private val zipper: Zipper? = null

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    fun sendDailyMail() {
        zipper?.zipFiles()
        // TODO: send mail to admin
    }
}