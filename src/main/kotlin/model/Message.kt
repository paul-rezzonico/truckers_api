package com.paulrezzonico.model

data class Message(
    val id: String,
    val envoyeur: NumeroDeTelephone,
    val message: String,
    val dateReception: String
)
