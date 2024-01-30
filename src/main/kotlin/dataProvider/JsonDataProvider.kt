package com.uniLim.info.dataProvider

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path

@Component
class JsonDataProvider : IDataProvider {

    @Value("\${json.filepath}")
    private lateinit var jsonFilePath: String
    override fun getData(fileName: String): Destinataire? {
        var messages: Destinataire? = null
        try {
            messages = chargerDestinataire(fileName)
        } catch (e: Exception) {
            logger.error("Une erreur est survenue lors de la tentative de lecture du fichier JSON $fileName", e)
            e.printStackTrace()
        }
        return messages
    }

    override fun addData(destinataire: String, messages: List<Message>, fileName: String): Boolean {
        val file = Path.of("$jsonFilePath$fileName").toFile()

        try {
            val objectMapper = jacksonObjectMapper()

            if (!file.exists()) {
                val newDestinataire = Destinataire(idTelephone = destinataire, messages = messages.toMutableList())
                objectMapper.writeValue(file, newDestinataire)
                return true
            } else {
                logger.info("Le fichier pour le destinataire $destinataire existe déjà. Aucune action de création n'est effectuée.")
                logger.info("Ajout des messages pour le destinataire $destinataire")
                val existingDestinataire: Destinataire = chargerDestinataire(fileName)
                existingDestinataire.messages.addAll(messages)
                logger.info("messages mis à jour : ${existingDestinataire.messages}")
                objectMapper.writeValue(file, existingDestinataire)
                return true
            }
        } catch (e: Exception) {
            logger.error("Une erreur est survenue lors de la tentative de création du fichier JSON pour le destinataire $destinataire", e)
            e.printStackTrace()
            return false
        }
    }

    private fun chargerDestinataire(fileName: String): Destinataire {
        val file = Path.of("$jsonFilePath$fileName")
        if (!Files.exists(file)) {
            logger.info("Le fichier $fileName n'existe pas")
            throw NoSuchElementException("Le fichier $fileName n'existe pas")
        }
        val json = String(Files.readAllBytes(file))

        val objectMapper = jacksonObjectMapper()
        return objectMapper.readValue(json, Destinataire::class.java)
    }

    private val logger = LoggerFactory.getLogger(javaClass)
}
