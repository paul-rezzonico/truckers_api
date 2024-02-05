package com.uniLim.info.unit

import com.uniLim.info.dataProvider.JsonDataProvider
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockedStatic
import org.mockito.Mockito.mockStatic
import java.nio.file.Files
import java.nio.file.Path

class JsonDataProviderTest {

    private lateinit var jsonDataProvider: JsonDataProvider
    private lateinit var mockedPathCompanion: MockedStatic<Path>

    @BeforeEach
    fun setUp() {
        jsonDataProvider = JsonDataProvider()

        val jsonFilePathField = JsonDataProvider::class.java.getDeclaredField("jsonFilePath")
        jsonFilePathField.isAccessible = true
        jsonFilePathField.set(jsonDataProvider, "")

        val temporaryFile = Files.createTempFile("temp", ".json")
        fillTempFile(temporaryFile.toFile())

        val fileToCreatePath = Files.createTempFile("FileToCreate", ".json")
        Files.deleteIfExists(fileToCreatePath)

        mockedPathCompanion = mockStatic(Path::class.java)

        mockedPathCompanion.`when`<Any> { Path.of("test.json") }.thenReturn(temporaryFile)

        mockedPathCompanion.`when`<Any> { Path.of("FileToCreate.json") }.thenReturn(fileToCreatePath)

    }

    @Test
    fun `test loadJsonData successfully loads data`() {
        val result = jsonDataProvider.getData("test.json")
        assertThat(result)
            .isNotNull
            .isInstanceOfAny(Destinataire::class.java)
        assertThat(result?.idTelephone).isEqualTo("randomPhoneId")
        assertThat(result?.messages?.size).isEqualTo(1)
    }

    @Test
    fun `test loadJsonData returns null when file does not exist`() {
        val result = jsonDataProvider.getData("nonExistentFile.json")
        assertThat(result).isNull()
    }

    @Test
    fun `test addData creates file and adds messages when file does not exist`() {
        val destinataire = "0123456789"
        val messages = listOf(
            Message("id2", NumeroDeTelephone("0123456789"), "TestMessage2", "TestDate2"),
            Message("id3", NumeroDeTelephone("0123456789"), "TestMessage3", "TestDate3")
        )
        val result = jsonDataProvider.addData(destinataire, messages, "FileToCreate.json")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `test addData adds messages when file exists`() {
        val destinataire = "randomPhoneId"
        val messages = listOf(
            Message("id2", NumeroDeTelephone("0123456789"), "TestMessage2", "TestDate2"),
            Message("id3", NumeroDeTelephone("0123456789"), "TestMessage3", "TestDate3")
        )
        val result = jsonDataProvider.addData(destinataire, messages, "test.json")
        assertThat(result).isEqualTo(2)
        assertThat(jsonDataProvider.getData("test.json")?.messages?.size).isEqualTo(3)
    }

    @Test
    fun `test addData does not add messages when file exists and messages are already present`() {
        val destinataire = "randomPhoneId"
        val messages = listOf(
            Message("id1", NumeroDeTelephone("0123456789"), "TestMessage", "TestDate"),
        )
        val initialSize = jsonDataProvider.getData("test.json")?.messages?.size
        val preprocessed = jsonDataProvider.addData(destinataire, messages, "test.json")
        assertThat(preprocessed).isEqualTo(1)
        assertThat(jsonDataProvider.getData("test.json")?.messages?.size)
            .isEqualTo(1)
            .isEqualTo(initialSize)
    }

    @AfterEach
    fun tearDown() {
        mockedPathCompanion.close()
    }
}
