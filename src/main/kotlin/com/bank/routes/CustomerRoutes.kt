package com.bank.routes

import com.bank.dto.customer.Customer
import com.bank.dto.customer.CustomerInfo
import com.bank.repository.CustomerRepository
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class CustomerRoutes(private val customerRepository: CustomerRepository) {
   fun register(parent: Route): Route {
      return parent.route("/customers") {
         get {
            call.respond(customerRepository.getAll())
         }

         get("/") {
            call.requireId()
         }

         get("/{id}/info") {
            val id = call.requireId()
            val customer = customerRepository.get(id)
            val customerInfo = CustomerInfo(customer)
            call.respond(customerInfo)
         }

         get("/{id}") {
            val id = call.requireId()
            call.respond(customerRepository.get(id))
         }


         put("/{id}") {
            val id = call.requireId()
            val customerRequest = call.receive<Customer>()
            call.respond(customerRepository.update(id, customerRequest))
         }

         post {
            val customerRequest = call.receive<Customer>()
            val customerCreate = customerRepository.add(customerRequest)
            call.respond(customerCreate)
         }

         delete("/") {
            call.requireId()
         }

         delete("/{id}") {
            val id = call.requireId()
            call.respond(customerRepository.delete(id))
         }
      }
   }

   fun ApplicationCall.requireId(): Int {
      val idParam = parameters["id"] ?: throw BadRequestException("Debe especificar el id")
      val id = idParam.toIntOrNull() ?: throw BadRequestException("id: $idParam, inválido")
      return id
   }

}