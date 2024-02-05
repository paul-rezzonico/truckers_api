package com.uniLim.info.unit

import com.uniLim.info.controller.FileServingController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(FileServingController::class)
class FileServingControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var resourceLoader: ResourceLoader

    @Test
    fun `when File Exists then Serve File`() {
        // TODO: Replace with a temporary directory
    }

    @Test
    fun `when File Does Not Exist then Return Not Found`() {
        // Given
        val filename = "nonExistentFile.json"
        val resource = mock(Resource::class.java)

        given(resourceLoader.getResource("file:jsonFilePath$filename")).willReturn(resource)
        given(resource.exists()).willReturn(false)

        mockMvc.perform(get("/public/$filename"))
                .andExpect(status().isNotFound())
    }
}
