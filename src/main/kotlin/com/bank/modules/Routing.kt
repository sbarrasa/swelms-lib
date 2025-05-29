package com.bank.modules

import com.bank.routes.CodesRoutes
import com.bank.routes.CustomerRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configRoutes(){
    val root = this.routing {}
    CustomerRoutes(RepositoryRegistry.repository).register(root)
    CodesRoutes.register(root)
}