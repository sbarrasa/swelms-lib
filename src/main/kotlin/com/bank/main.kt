package com.bank

import com.bank.services.CustomerRepositoryFactory
import com.bank.routes.initModules
import com.sbarrasa.common.locale.Locale
import com.sbarrasa.common.system.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger("Application")

fun main(args: Array<String>) {
   val repo = SysProp["repo"]?:"MEM"
   log.info("Repository: $repo")
   val customerRepo = CustomerRepositoryFactory[repo]

   Locale
      .apply {rootPackage = "com.bank.locale"
              lang = SysProp["lang"] }
      .also {log.info("Language: ${it.lang}") }
      .load()

   embeddedServer(
      factory = Netty,
      port = 8080,
      module = { initModules(customerRepo) })
      .start(wait = true)
}




