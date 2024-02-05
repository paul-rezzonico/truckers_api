package com.uniLim.info.unit

import com.fasterxml.jackson.databind.ObjectMapper
import com.uniLim.info.controller.MessageController
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone
import com.uniLim.info.service.MessageService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@ExtendWith(SpringExtension::class)
@WebMvcTest(MessageController::class)
class MessageControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var messageService: MessageService

    @Test
    fun `when Get By Phone Id then Return Messages`() {
        // Given
        val id = "123"
        val messages = listOf(
            Message(
                id = "1",
                envoyeur = NumeroDeTelephone("0123456789"),
                message = "Hello",
                dateReception = "2021-01-01"
            )
        )
        given(messageService.getByPhoneId(id)).willReturn(messages)

        mockMvc.perform(get("/messages/$id"))
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(messages)))

        verify(messageService).getByPhoneId(id)
    }

    @Test
    fun `when Post Synchronize Messages then Return Status`() {
        // Given
        val destinataire = Destinataire(
            "123", mutableListOf(
                Message(
                    id = "1",
                    envoyeur = NumeroDeTelephone("0123456789"),
                    message = "Hello",
                    dateReception = "2021-01-01"
                )
            )
        )
        given(messageService.update(anyString(), anyList())).willReturn(1)

        mockMvc.perform(
            post("/messages/sync")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(destinataire))
        )
            .andExpect(status().isOk)
            .andExpect(content().string("1"))

        verify(messageService).update(destinataire.idTelephone, destinataire.messages)
    }
}
