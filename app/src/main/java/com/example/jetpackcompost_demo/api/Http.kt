package com.example.jetpackcompost_demo.api

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val http = HttpClient {
    expectSuccess = true

    install(Logging) {
        logger = Logger.ANDROID
        level = LogLevel.BODY
    }

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
        )
    }
}


