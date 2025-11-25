package com.bank.ktor

import com.bank.ktor.config.configDatabase
import com.bank.ktor.config.configLocale
import com.bank.ktor.config.configLog
import com.bank.ktor.config.configSerialization
import com.bank.ktor.config.configStatusPages
import com.bank.ktor.routes.codesRoutes
import com.bank.ktor.routes.customerProductsRoutes
import com.bank.ktor.routes.customerRoutes
import io.ktor.server.application.Application

fun Application.configModule() {
   configLocale()
   configLog()
   configStatusPages()
   configSerialization()
   configDatabase()
   customerRoutes()
   codesRoutes()
   customerProductsRoutes()
}