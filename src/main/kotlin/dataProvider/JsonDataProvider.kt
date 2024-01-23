package com.uniLim.info.dataProvider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path

@Component
class JsonDataProvider(private val resourceLoader: ResourceLoader) : IDataProvider {

    @Value("\${json.filepath}")
    private lateinit var jsonFilePath: String
    override fun getData(fileName: String): List<Destinataire> {
        val messages = chargerDestinataires(fileName)
        return messages
    }

    override fun addData(destinataire: NumeroDeTelephone, messages: List<Message>, fileName: String): Boolean {
        try {
            val file = Path.of("$jsonFilePath/$fileName").toFile()
            val json = String(Files.readAllBytes(file.toPath()))

            val objectMapper = jacksonObjectMapper()
            val typeRef = object : TypeReference<Map<String, List<Destinataire>>>() {}
            val root = objectMapper.readValue(json, typeRef)
            val destinataires = root["destinataires"]?.toMutableList() ?: mutableListOf()
            val destinataireExistant = destinataires.find { it.numero.numero == destinataire.numero }

            destinataireExistant?.let { existant ->
                messages.forEach() { message ->
                    existant.messages.addLast(message)
                }
            } ?: run {
                destinataires.add(Destinataire(destinataire, messages))
            }
            val newRoot = mapOf("destinataires" to destinataires)
            objectMapper.writeValue(file, newRoot)
            return true

        } catch (e: Exception) {
            logger.error("Une erreur est survenue lors de la lecture ou de l'écriture du fichier JSON", e)
            e.printStackTrace()
            return false
        }
    }

    private fun chargerDestinataires(fileName: String): List<Destinataire> {
        val file = Path.of("$jsonFilePath/$fileName")
        val json = String(Files.readAllBytes(file))

        val objectMapper = jacksonObjectMapper()
        return try {
            val typeRef = object : TypeReference<Map<String, List<Destinataire>>>() {}
            val root = objectMapper.readValue(json, typeRef)
            root["destinataires"] ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private val logger = LoggerFactory.getLogger(javaClass)
}
