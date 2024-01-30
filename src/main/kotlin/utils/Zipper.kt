package com.uniLim.info.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDate
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@Component
class Zipper {

    @Value("\${json.filepath}")
    private lateinit var jsonFilePath: String

    fun zipFiles(): Path {
        val today = LocalDate.now()
        Path.of(jsonFilePath)
        val zipPath = Path.of("$jsonFilePath${today.year}${String.format("%02d", today.monthValue)}${String.format("%02d", today.dayOfMonth)}.zip").toFile()

        Files.newDirectoryStream(Path.of(jsonFilePath)).use { stream ->
            ZipOutputStream(BufferedOutputStream(FileOutputStream(zipPath))).use { zos ->
                stream.forEach { path ->
                    if (path.toString().contains(today.toString())) {
                        val id = extractIdFromFileName(path.fileName.toString())
                        val cheminDansZip = "$id/${path.fileName}"
                        zos.putNextEntry(ZipEntry(cheminDansZip))
                        Files.copy(path, zos)
                        zos.closeEntry()
                    }
                }
            }
        }
        return zipPath.toPath()
    }

    private fun extractIdFromFileName(string: String): Any {
        val regex = Regex("-(\\d{4}-\\d{2}-\\d{2})-(.*).json$")
        val matchResult = regex.find(string)
        return matchResult?.groups?.get(2)?.value ?: ""
    }
}