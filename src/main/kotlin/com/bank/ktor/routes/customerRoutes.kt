package com.bank.ktor.routes

import com.bank.model.customer.Customer
import com.bank.model.customer.CustomerInfo
import com.bank.database.customer.ExposedCustomerRepository
import io.ktor.server.application.*
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.customerRoutes() {
   val customerRepository = ExposedCustomerRepository
   routing {
      route("/customers") {
         get {
            call.respond(customerRepository.getAll())
         }

         get("/") {
            call.getValidCustomerId()
         }

         get("/{id}/info") {
            val id = call.getValidCustomerId()
            val customer = customerRepository.get(id)
            val customerInfo = CustomerInfo(customer)
            call.respond(customerInfo)
         }

         get("/{id}") {
            val id = call.getValidCustomerId()
            call.respond(customerRepository.get(id))
         }


         put("/{id}") {
            val id = call.getValidCustomerId()
            val customerRequest = call.receive<Customer>()
            call.respond(customerRepository.update(id, customerRequest))
         }

         post {
            val customerRequest = call.receive<Customer>()
            val customerCreate = customerRepository.add(customerRequest)
            call.respond(customerCreate)
         }

         delete("/") {
            call.getValidCustomerId()
         }

         delete("/{id}") {
            val id = call.getValidCustomerId()
            call.respond(customerRepository.delete(id))
         }
      }
   }
}


internal fun ApplicationCall.getValidCustomerId(): Int {
   val idParam = parameters["id"] ?: throw BadRequestException("Debe especificar el id")
   val id = idParam.toIntOrNull() ?: throw BadRequestException("id: $idParam, inválido")
   return id
}
