package com.bank

import com.bank.services.CustomerRepositoryFactory
import com.bank.routes.initModules
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.sbarrasa.args.*
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger("Application")

fun main(args: Array<String>) {
   val repoSource = args["repo"]?:"MEM"
   log.info("Repository source: $repoSource")

   val customerRepo = CustomerRepositoryFactory.get(repoSource)

   val restServer = embeddedServer(
      factory = Netty,
      port = 8080,
      module = { initModules(customerRepo) })

   restServer.start(wait = true)
}



