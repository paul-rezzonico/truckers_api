package com.uniLim.info.unit

import java.io.File

fun fillTempFile(file: File) {
    val content = """
        {
            "idTelephone": "randomPhoneId",
            "messages": [
                {
                    "id": "id1",
                    "envoyeur": "0123456789",
                    "message": "TestMessage",
                    "dateReception": "TestDate"
                }
            ]
        }
    """.trimIndent()

    file.writer().use { it.write(content) }
}
