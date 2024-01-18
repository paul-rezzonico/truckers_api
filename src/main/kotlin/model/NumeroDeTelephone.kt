package com.paulrezzonico.model

import com.fasterxml.jackson.annotation.JsonValue

data class NumeroDeTelephone(@get:JsonValue var numero: String)