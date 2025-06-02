package com.bank.modules

import com.bank.routes.CodesRoutes
import com.bank.routes.CustomerRoutes
import com.sbarrasa.repository.EntityNotFoundException
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.module() {
    configHTTP()
    configSerialization()
    configRoutes()
}

internal fun Application.configSerialization() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/json/test") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

internal fun Application.configRoutes(){
    routing {
        CustomerRoutes(RepositoryFactory.create()).register(this)
        CodesRoutes.register(this)
    }
}

internal fun Application.configHTTP() {
    install(StatusPages) {
        handleException<BadRequestException>(HttpStatusCode.BadRequest)
        handleException<EntityNotFoundException>(HttpStatusCode.NotFound)
    }
}

internal inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
    exception<T> { call, cause ->
        call.respond(status, cause.message ?: status.description)
    }
}