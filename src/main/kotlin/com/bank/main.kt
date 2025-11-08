package com.bank

import com.bank.model.product.factory.ProductFactory
import com.bank.modules.H2Server
import com.bank.modules.RepositoryFactory
import com.bank.modules.init
import com.bank.modules.module
import com.sbarrasa.util.args.get
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
   H2Server.start()
   ProductFactory.init()
   RepositoryFactory.setType(args[RepositoryFactory.paramKey])
   embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
   H2Server.stop()
}



