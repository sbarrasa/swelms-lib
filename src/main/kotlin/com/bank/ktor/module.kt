package com.bank.ktor

import com.bank.database.customer.CustomerRepository
import io.ktor.server.application.*

val logger = org.slf4j.LoggerFactory.getLogger("Application")

fun Application.module(repo: CustomerRepository) {
   configStatusPages()
   configSerialization()
   customerRoutes(repo)
   codesRoutes()
   customerProductsRoutes()
   configLog()
}


