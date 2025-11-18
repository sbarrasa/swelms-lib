package com.bank.routes

import com.bank.model.customer.CustomerProducts
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route

class CustomerProductsRoutes {
   fun register(parent: Route): Route {
      return parent.route("/customer/{id}/products") {
         post {
            val customerProduct = call.receive<CustomerProducts>()
           call.respond(customerProduct)
         }
      }
   }
}