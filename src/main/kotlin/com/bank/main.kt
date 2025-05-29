package com.bank

import com.bank.modules.*
import com.bank.model.product.factory.ProductRegistry
import com.bank.modules.RepositoryRegistry
import com.sbarrasa.util.args.get

fun main(args: Array<String>) {
    H2Server.start()
    ProductRegistry.init()
    RepositoryRegistry.setType(args[RepositoryRegistry.paramKey])
    HTTPServer.start(wait = true)
    H2Server.stop()
}



