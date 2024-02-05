package com.uniLim.info.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import java.nio.file.Paths

@RestController
class FileServingController(private val resourceLoader: ResourceLoader) {

    @Value("\${json.filepath}")
    private lateinit var jsonFilePath: String

    @GetMapping("/public/{filename}")
    fun serveFile(@PathVariable filename: String): ResponseEntity<Resource> {
        val resource = resourceLoader.getResource("file:$jsonFilePath$filename")
        val file = resource.file

        if (!file.exists() || !file.isFile) {
            return ResponseEntity.notFound().build()
        }

        val fileResource = resourceLoader.getResource("file:${file.absolutePath}")
        val headers = HttpHeaders()
        headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(file.absolutePath)))

        return ResponseEntity.ok()
            .headers(headers)
            .body(fileResource)
    }
}