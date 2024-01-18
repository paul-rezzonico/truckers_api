package com.paulrezzonico.model

import com.paulrezzonico.Modele.NumeroDeTelephone

class Message(
    val id: Long = obtenirId(),
    val numeroDeTelephone: NumeroDeTelephone,
    val message: String,
    val date: String
) {
    companion object {
        private var id: Long = 0
        private fun obtenirId(): Long {
            return ++id
        }
    }
}
