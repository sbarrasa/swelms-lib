package com.bank.ktor.config

import com.bank.services.ProductTypes
import com.swelms.common.serialization.polymorphic
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

@OptIn(ExperimentalSerializationApi::class)
internal fun Application.configSerialization() {
   install(ContentNegotiation) {
      json(
         Json {
            serializersModule = SerializersModule {
               polymorphic(ProductTypes)
            }
            classDiscriminator = "type"
            ignoreUnknownKeys = true
            explicitNulls = false


         }
      )
   }
   routing {
      get("/json/test") {
         call.respond(mapOf("hello" to "world"))
      }
   }
}
