package com.bank.routes

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductTypes
import com.bank.service.Codes
import com.sbarrasa.util.CaseType.SNAKE
import com.sbarrasa.util.simpleName
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


object CodesRoutes {
   fun register(parent: Route) {

      parent.route("/codes") {
         get("/all") {
            call.respond(Codes)
         }

         get("/") {
            call.respond(Codes.keys)
         }

         get("/${Gender::class.simpleName(SNAKE)}") {
            call.respond(Gender.asMap())
         }

         get("/${Branch::class.simpleName(SNAKE)}") {
            call.respond(Branch.asMap())
         }

         get("/${Currency::class.simpleName(SNAKE)}") {
            call.respond(Currency.asMap())
         }

         get("/${ProductTypes::class.simpleName(SNAKE)}") {
            call.respond(ProductTypes.asMap())
         }
      }
   }
}