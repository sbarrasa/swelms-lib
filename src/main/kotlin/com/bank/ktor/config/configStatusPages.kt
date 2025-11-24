package com.bank.ktor.config

import com.bank.model.error.ErrorDetail
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.ContentTransformationException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.plugins.statuspages.StatusPagesConfig
import io.ktor.server.response.respond
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("HTTPRequest")

internal fun Application.configStatusPages() {
   install(StatusPages) {
      handleException<BadRequestException>(HttpStatusCode.BadRequest)
      handleException<ContentTransformationException>(HttpStatusCode.BadRequest)
      handleException<NoSuchElementException>(HttpStatusCode.NotFound)
      handleException<Throwable>(HttpStatusCode.InternalServerError)
   }
}


internal inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
   exception<T> { call, cause ->
      val error = ErrorDetail(cause)
      logger.error("$error")

      call.respond(status, error)
   }
}