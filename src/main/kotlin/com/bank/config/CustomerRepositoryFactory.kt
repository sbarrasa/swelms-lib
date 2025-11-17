package com.bank.config

import com.bank.repository.CustomerRepository
import com.bank.repository.CustomersTable
import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository
import com.sbarrasa.registry.Registry

object CustomerRepositoryFactory: Registry<String, CustomerRepository>() {
   init {
      register("MEM") { MemCustomerRepository }

      register("EXPOSED") {
         DBClient.init(CustomersTable)
         ExposedCustomerRepository
      }
   }
}