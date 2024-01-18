package com.paulrezzonico.model

data class Destinataire(
    val numero: NumeroDeTelephone,
    val messages : List<Message>
)