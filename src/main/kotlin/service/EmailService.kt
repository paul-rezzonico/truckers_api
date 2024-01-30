package service

import jakarta.mail.MessagingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService(@Autowired private val emailSender: JavaMailSender) {

    @Throws(MessagingException::class)
    fun sendMail(to: String, subject: String, text: String, cheminPieceJointe: String) {
        val message = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)

        helper.setFrom("truckers.api@gmail.com")
        helper.setTo(to)
        helper.setSubject(subject)
        helper.setText(text)

        val file = FileSystemResource(cheminPieceJointe)
        helper.addAttachment(file.filename ?: "attachment.zip", file)

        emailSender.send(message)
    }
}