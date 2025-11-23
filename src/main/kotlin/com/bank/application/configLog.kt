package com.bank.application

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging
import org.slf4j.event.Level

internal fun Application.configLog() {
   install(CallLogging) {
      level = Level.DEBUG
   }
}