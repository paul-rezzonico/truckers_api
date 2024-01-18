package com.paulrezzonico.model

import java.util.*

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val envoyeur: NumeroDeTelephone,
    val message: String,
    val dateReception: String
)
