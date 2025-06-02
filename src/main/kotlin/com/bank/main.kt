package com.bank

import com.bank.modules.*
import com.bank.model.product.factory.ProductTypes
import com.bank.modules.RepositoryFactory
import com.sbarrasa.util.args.get
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    H2Server.start()
    ProductTypes.init()
    RepositoryFactory.setType(args[RepositoryFactory.paramKey])
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
    H2Server.stop()
}



