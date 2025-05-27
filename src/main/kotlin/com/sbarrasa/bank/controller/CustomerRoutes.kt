package com.sbarrasa.bank.controller

import com.sbarrasa.bank.entities.customer.Customer
import com.sbarrasa.bank.service.CustomerService
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.request.*
class CustomerRoutes(val customerService: CustomerService) {
    fun register(route: Route, ) {
        route.route("/customers") {
            get {
                call.respond(customerService.getAll())
            }

            get ("/") {
                call.requireId()
            }

            get("/{id}") {
                val id = call.requireId()
                call.respond(customerService.get(id))
            }
            post {
                val customerRequest = call.receive<Customer>()
                call.respond(customerService.add(customerRequest))
            }

            put  ("/") {
                call.requireId()
            }

            put("/{id}") {
                val id = call.requireId()
                val customerRequest = call.receive<Customer>()
                call.respond(customerService.update(id, customerRequest))
            }

            delete ("/") {
                call.requireId()
            }

            delete("/{id}") {
                val id = call.requireId()
                call.respond(customerService.delete(id))
            }
        }
    }
    fun ApplicationCall.requireId(): Int {
        val idParam = parameters["id"] ?: throw BadRequestException("Debe especificar el id")
        val id = idParam.toIntOrNull() ?: throw BadRequestException("id: $idParam, inválido")
        return id
    }

}