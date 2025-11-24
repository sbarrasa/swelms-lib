package com.bank.ktor.routes

import com.bank.database.CustomerService
import com.bank.model.customer.Customer
import com.bank.model.customer.CustomerInfo
import com.sbarrasa.common.locale.localeText
import io.ktor.server.application.*
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.customerRoutes() {
   routing {
      route("/customers") {
         get {
            call.respond(CustomerService.getAll())
         }

         get("/") {
            call.getValidCustomerId()
         }

         get("/{id}/info") {
            val id = call.getValidCustomerId()
            val customer = CustomerService.get(id)
            val customerInfo = CustomerInfo(customer)
            call.respond(customerInfo)
         }

         get("/{id}") {
            val id = call.getValidCustomerId()
            call.respond(CustomerService.get(id))
         }

         put("/{id}") {
            val id = call.getValidCustomerId()
            val customerRequest = call.receive<Customer>()
            val customerUpdated = CustomerService.update(id, customerRequest)
            call.respond(customerUpdated)
         }


         post("/find") {
            val customerRequest = call.receive<Customer>()
            call.respond<Customer>(customerRequest)
         }

         post {
            val customerRequest = call.receive<Customer>()
            val customerCreate = CustomerService.add(customerRequest)
            call.respond(customerCreate)
         }


         delete("/{id}") {
            val id = call.getValidCustomerId()
            call.respond(CustomerService.delete(id))
         }
      }
   }
}


internal fun ApplicationCall.getValidCustomerId(): Int {
   val idParam = parameters["id"] ?: throw BadRequestException(CustomerService.localeText["ID_CANT_BE_EMPTY"])
   val id = idParam.toIntOrNull() ?: throw BadRequestException("${CustomerService.localeText["INVALID_CUSTOMER_ID"]}: $idParam")
   return id
}
