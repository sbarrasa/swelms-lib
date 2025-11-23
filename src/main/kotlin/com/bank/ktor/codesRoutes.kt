package com.bank.ktor

import com.bank.services.CodesCatalog
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.codesRoutes() {
   routing {
      route("/codes") {
         get("/all") {
            call.respond(CodesCatalog)
         }

         get("/") {
            call.respond(CodesCatalog.keys)
         }

         get("/{code}") {
            val code = call.parameters["code"]
            val map = CodesCatalog[code] ?: throw NotFoundException("Code $code not found")
            call.respond(map)
         }
      }
   }
}

