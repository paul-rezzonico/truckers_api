package com.uniLim.info.scheduling

import com.uniLim.info.service.MailService
import com.uniLim.info.utils.Zipper
import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component


@Component
class SendDailyMail {

    @Autowired
    private lateinit var zipper: Zipper

    @Autowired
    private lateinit var emailSender: MailService

    @Value("\${mail.admin}")
    private lateinit var mail: String

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    fun sendDailyMail() {
        logger.info("Start sending daily mail")
        logger.info("Zip files")
        val zipPath = zipper.zipFiles()
        logger.info("Zip files done")
        logger.info("Send mail to $mail")

        emailSender.sendMail(
            to=mail,
            subject="Fichier journalier des messages",
            text="Bonjour,\n\nVeuillez trouver ci-joint le fichier journalier des messages.\n\nCordialement,\n\nCeci est un mail automatique, merci de ne pas y répondre.",
            zipPath=zipPath
            )
        logger.info("Send mail done")
    }

    private val logger: Logger = LoggerFactory.getLogger(SendDailyMail::class.java)
}