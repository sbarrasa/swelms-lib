package com.bank.application

import io.ktor.server.application.*

val logger = org.slf4j.LoggerFactory.getLogger("Application")

fun Application.module() {
   configStatusPages()
   configSerialization()
   configDatabase()
   customerRoutes()
   codesRoutes()
   customerProductsRoutes()
   configLog()
}


