package com.paulrezzonico.exception

import org.springframework.http.HttpStatus

class NumeroInexistantException(notFound: HttpStatus, s: String): Throwable() {

}
