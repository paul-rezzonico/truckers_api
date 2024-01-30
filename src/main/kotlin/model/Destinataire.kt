package com.uniLim.info.model

data class Destinataire(
    val idTelephone: String,
    val messages : MutableList<Message>
)