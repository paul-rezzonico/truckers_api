package com.uniLim.info.dataProvider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone
import org.slf4j.LoggerFactory
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths

@Component
class JsonDataProvider(private val resourceLoader: ResourceLoader) : IDataProvider {

    override fun getData(fileName: String): List<Destinataire> {
        val messages = chargerDestinataires(fileName)
        return messages
    }

    override fun addData(destinataire: NumeroDeTelephone, messages: List<Message>, fileName: String): Boolean {
        try {
            val resource = resourceLoader.getResource("classpath:/public/$fileName")
            val file = resource.file
            val json = String(Files.readAllBytes(Paths.get(file.toURI())))
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
        val resource = resourceLoader.getResource("classpath:/public/$fileName")
        val file = resource.file
        val json = String(Files.readAllBytes(Paths.get(file.toURI())))

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