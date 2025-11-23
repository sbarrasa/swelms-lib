package com.bank.ktor.config

import com.sbarrasa.common.locale.Locale
import io.ktor.server.application.Application
import io.ktor.server.application.log

fun Application.configLocale() {
   Locale
      .apply {
         rootPackage = "com.bank.locale"
         lang = environment.config.propertyOrNull("locale.lang")?.getString()
      }
      .load()
   log.info("Language: ${Locale.lang}")
   log.info("Language: ${Locale.lang}")
}
