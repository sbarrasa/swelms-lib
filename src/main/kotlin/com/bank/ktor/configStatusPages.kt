package com.bank.ktor

import com.sbarrasa.repository.EntityNotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.ContentTransformationException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.plugins.statuspages.StatusPagesConfig
import io.ktor.server.response.respond

internal fun Application.configStatusPages() {
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
