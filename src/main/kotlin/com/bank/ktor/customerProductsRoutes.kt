package com.bank.ktor

import com.bank.model.customer.CustomerProducts
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.customerProductsRoutes() {
   routing {
      route("/customer/{id}/products") {
         post {
            val customerProduct = call.receive<CustomerProducts>()
           call.respond(customerProduct)
         }
      }
   }
}