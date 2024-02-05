package com.uniLim.info.unit

import com.fasterxml.jackson.databind.ObjectMapper
import com.uniLim.info.controller.MessageErrorController
import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message
import com.uniLim.info.model.NumeroDeTelephone
import com.uniLim.info.service.ErrorMessagesService
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
@WebMvcTest(MessageErrorController::class)
class MessageErrorControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var errorMessagesService: ErrorMessagesService

    @Test
    fun `when Get By Phone Id then Return Error Messages`() {
        val id = "123"
        val messages = listOf(
            Message(
                id = "123",
                envoyeur = NumeroDeTelephone("0123456789"),
                message = "Hello",
                dateReception = "2021-01-01"
            )
        )
        given(errorMessagesService.getErrorByPhoneId(id)).willReturn(messages)

        mockMvc.perform(get("/messages_err/$id"))
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(messages)))

        verify(errorMessagesService).getErrorByPhoneId(id)
    }

    @Test
    fun `when Post Synchronize Error Messages then Return Status`() {
        val destinataire = Destinataire(
            idTelephone = "123",
            messages = mutableListOf(
                Message(
                    id = "123",
                    envoyeur = NumeroDeTelephone("0123456789"),
                    message = "Hello",
                    dateReception = "2021-01-01"
                )
            )
        )
        given(errorMessagesService.updateError(anyString(), anyList())).willReturn(1)

        mockMvc.perform(
            post("/messages_err/sync")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(destinataire))
        )
            .andExpect(status().isOk)
            .andExpect(content().string("1"))

        verify(errorMessagesService).updateError(destinataire.idTelephone, destinataire.messages)
    }
}
