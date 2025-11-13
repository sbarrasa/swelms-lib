package com.bank

import com.bank.dto.product.factory.ProductFactory
import com.bank.repository.RepositoryFactory
import com.bank.config.init
import com.bank.routes.initModules
import com.sbarrasa.util.args.get
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
   ProductFactory.init()

   val repo = RepositoryFactory.get(args["repo"])

   val restServer = embeddedServer(
      factory = Netty,
      port = 8080,
      module = { initModules(repo) })

   restServer.start(wait = true)
}



