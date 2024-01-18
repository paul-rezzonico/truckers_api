package com.paulrezzonico.dataProvider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.Message
import com.paulrezzonico.model.NumeroDeTelephone
import org.slf4j.LoggerFactory
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths

@Component
class JsonDataProvider(private val resourceLoader: ResourceLoader) : IDataProvider  {

    override fun getData(): List<Destinataire> {
        val messages = chargerDestinataires()
        return messages
    }

    override fun addData(destinataire: NumeroDeTelephone, message: Message) {
        try {
            val resource = resourceLoader.getResource("classpath:Test.json")

        } catch (e: Exception) {
            logger.error("Une erreur est survenue lors de la lecture ou de l'écriture du fichier JSON", e)
            e.printStackTrace()
        }
    }

    private fun chargerDestinataires(): List<Destinataire> {
        val resource = resourceLoader.getResource("classpath:Test.json")
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