package com.bank.routes

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductRegistry
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object CodesRoutes {
    fun register(parent: Route){
        parent.route("/codes"){
            get("/gender"){
                call.respond(Gender.asMap())
            }

            get("/branch"){
                call.respond(Branch.asMap())
            }

            get("/currency"){
                call.respond(Currency.asMap())
            }

            get("/product_types"){
                call.respond(ProductRegistry.asMap())
            }

        }
    }
}