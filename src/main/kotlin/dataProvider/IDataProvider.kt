package com.uniLim.info.dataProvider

import com.uniLim.info.model.Destinataire
import com.uniLim.info.model.Message

interface IDataProvider {
    fun getData(fileName: String): List<Destinataire>

    fun addData(destinataire : String, messages: List<Message>, fileName: String): Boolean
}