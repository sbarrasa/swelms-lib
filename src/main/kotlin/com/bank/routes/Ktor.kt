package com.bank.routes

import com.bank.repository.customer.CustomerRepository
import com.bank.services.ProductTypes
import com.sbarrasa.repository.EntityNotFoundException
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.callloging.*
import org.slf4j.event.Level

private val logger = org.slf4j.LoggerFactory.getLogger("Application")

fun Application.initModules(repo: CustomerRepository) {
   configHTTP()
   configSerialization()
   routing {
      CustomerRoutes(repo).register(this)
      CodesRoutes.register(this)
      CustomerProductsRoutes().register(this)
   }
   configLog()
}

internal fun Application.configLog() {
   install(CallLogging) {
      level = Level.DEBUG
   }
}

internal fun Application.configSerialization() {
   install(ContentNegotiation) {
      json(ProductTypes.json)
   }
   routing {
      get("/json/test") {
         call.respond(mapOf("hello" to "world"))
      }
   }
}


internal fun Application.configHTTP() {
   install(StatusPages) {
      handleException<BadRequestException>(HttpStatusCode.BadRequest)
      handleException<EntityNotFoundException>(HttpStatusCode.NotFound)
      handleException<ContentTransformationException>(HttpStatusCode.BadRequest)
   }
}

internal inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
   exception<T> { call, cause ->
      logger.error("Error ${status.value}: ${cause.message}", cause)
      val msg = generateSequence(cause as Throwable?) { it.cause }
         .mapNotNull { it.message }
         .lastOrNull() ?: status.description
      call.respond(status, mapOf(
         "error" to T::class.simpleName,
         "message" to msg
      ))
   }
}

fun ApplicationCall.getValidCustomerId(): Int {
   val idParam = parameters["id"] ?: throw BadRequestException("Debe especificar el id")
   val id = idParam.toIntOrNull() ?: throw BadRequestException("id: $idParam, inválido")
   return id
}
