package com.uniLim.info.exception

import org.springframework.http.HttpStatus

class MessageException(notFound: HttpStatus, s: String): Throwable() {

}
