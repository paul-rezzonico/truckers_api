package com.paulrezzonico.dataProvider

import com.paulrezzonico.model.Destinataire
import com.paulrezzonico.model.NumeroDeTelephone
import com.paulrezzonico.model.Message

interface IDataProvider {
    fun getData(fileName: String): List<Destinataire>

    fun addData(destinataire : NumeroDeTelephone, messages: List<Message>, fileName: String): Boolean
}