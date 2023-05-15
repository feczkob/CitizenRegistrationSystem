package com.crs

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    servers = [
        Server(
            url = "http://localhost:8080"
        )
    ],
    info = Info(
        title = "Citizen Registration System"
    )
)
class CitizenRegistrationSystemApplication

fun main(args: Array<String>) {
    runApplication<CitizenRegistrationSystemApplication>(*args)
}
