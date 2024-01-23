package com.uniLim.info.scheduling

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

@Component
class CreateDailyFile {

    @Value("\${json.filepath}")
    private lateinit var jsonFilePath: String

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    fun creerMessagesFichier() {
        creerFichier("Messages-${LocalDate.now()}.json")
    }

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    fun creerMessagesInvalidesFichier() {
        creerFichier("Erreurs-${LocalDate.now()}.json")
    }

     private fun creerFichier(fileName: String) {
        val filePath = Paths.get(jsonFilePath, fileName)
        if (!Files.exists(filePath)) {
            try {
                Files.createDirectories(filePath.parent)
                Files.writeString(filePath, "{}").also {
                    logger.info("Fichier $fileName créé à l'emplacement $filePath")
                }
            } catch (e: Exception) {
                logger.error("Erreur lors de la création du fichier $fileName", e)
            }
        } else {
            logger.info("Le fichier $fileName existe déjà")
        }
    }

    private val logger: Logger = LoggerFactory.getLogger(CreateDailyFile::class.java)
}