package com.paulrezzonico

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class TruckersApi

fun main(args: Array<String>) {
    runApplication<TruckersApi>(*args)
}
