package com.bank.ktor.routes

import com.bank.services.Codes
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.Locale
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.collections.get

fun Application.configRoutes() {
   routing {
      route("/lang") {
         put("/") {
            Locale.lang = null
            Codes.init()
            call.respond(mapOf("lang" to Locale.lang))
         }

         put("/{lang}") {
            call.parameters["lang"]?.let { Locale.lang = it }
            Codes.init()
            call.respond(mapOf("lang" to Locale.lang))
         }


      }
      route("/codes") {
         get("/all") {
            call.respond(Codes)
         }

         get("/") {
            call.respond(Codes.keys)
         }

         get("/{code}") {
            val code = call.parameters["code"]
            val map = Codes[code] ?: throw NotFoundException("Code $code not found")
            call.respond(map)
         }


      }
   }
}

