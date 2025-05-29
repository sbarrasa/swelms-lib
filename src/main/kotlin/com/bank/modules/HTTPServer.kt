package com.bank.modules

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

object HTTPServer : ApplicationEngine by embeddedServer(
    Netty,
    port = 8080,
    host = "localhost",
    module = Application::config
)

fun Application.config() {
    configHTTP()
    configSerialization()
    configRoutes()
}
