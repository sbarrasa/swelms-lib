package com.bank.modules

import com.sbarrasa.repository.EntityNotFoundException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*


fun Application.configHTTP() {
    routing {
        openAPI(path = "openapi")
        swaggerUI(path = "swagger", swaggerFile = "openapi")
    }

    install(StatusPages) {
        handleException<BadRequestException>(HttpStatusCode.BadRequest)
        handleException<EntityNotFoundException>(HttpStatusCode.NotFound)
    }
}

inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
    exception<T> { call, cause ->
        call.respond(status, cause.message ?: status.description)
    }
}
