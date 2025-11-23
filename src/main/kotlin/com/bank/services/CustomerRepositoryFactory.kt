package com.bank.services

import com.bank.database.customer.CustomerProductsTable
import com.bank.database.customer.CustomerRepository
import com.bank.database.customer.CustomersTable
import com.bank.database.customer.ExposedCustomerRepository
import com.bank.database.customer.MemCustomerRepository
import com.sbarrasa.common.registry.RegistryFactory

object CustomerRepositoryFactory: RegistryFactory<String, CustomerRepository>() {
   init {
      register("MEM") { MemCustomerRepository }

      register("EXPOSED") {
         DBClient.init(CustomersTable, CustomerProductsTable)
         ExposedCustomerRepository
      }
   }
}