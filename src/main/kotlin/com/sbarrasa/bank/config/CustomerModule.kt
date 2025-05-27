package com.sbarrasa.bank.config

import com.sbarrasa.bank.controller.CustomerRoutes
import com.sbarrasa.bank.repository.MemCustomerRepository
import com.sbarrasa.bank.service.CustomerService
import io.ktor.server.routing.*

object CustomerModule {
    private val repository = MemCustomerRepository()
    private val service = CustomerService(repository)
    private val routes = CustomerRoutes(service)

    fun register(route: Route) {
        routes.register(route)
    }
}