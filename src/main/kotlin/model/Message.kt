package com.paulrezzonico.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class Message(
    val id: Long = obtenirId(),
    val envoyeur: NumeroDeTelephone,
    val message: String,
    val dateReception: String
) {
    companion object {
        private var id: Long = 0
        private fun obtenirId(): Long {
            return ++id
        }
    }
}
