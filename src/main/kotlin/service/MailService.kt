package com.uniLim.info.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.nio.file.Path

@Service
class MailService {

    @Autowired
    private lateinit var emailSender: JavaMailSender
    fun sendMail(to: String, subject: String, text: String, zipPath: Path) {
        val message = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)

        helper.setFrom("truckers.api@gmail.com")
        helper.setTo(to)
        helper.setSubject(subject)
        helper.setText(text)
        helper.addAttachment(zipPath.fileName?.toString() ?: "attachment.zip", zipPath.toFile())
        emailSender.send(message)
    }
}