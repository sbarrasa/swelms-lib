package com.bank.ktor.config

import com.sbarrasa.common.locale.Locale
import io.ktor.server.application.Application
import io.ktor.server.application.log

fun Application.configLocale() {
   val lang = System.getenv("lang")
      ?: environment.config.propertyOrNull("locale.lang")?.getString()

   Locale.rootPackage = "com.bank.locale"
   Locale.lang = lang

   log.info("Language: ${Locale.lang}")
}
