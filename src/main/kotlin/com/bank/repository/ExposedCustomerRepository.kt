package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.repository.ExposedRepository
import com.sbarrasa.util.ObjectMapper

class ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { EntityToCustomer.map(it, Customer()) },
   mapToEntity = { dto, dbEntity -> CustomerToEntity.map(dto, dbEntity) }
) {
   object CustomerToEntity : ObjectMapper<Customer, CustomerEntity>({
      bindAll(Customer::class, CustomerEntity::class)
   })

   object EntityToCustomer : ObjectMapper<CustomerEntity, Customer>({
      bindAll(CustomerEntity::class, Customer::class)
      bind({ it.id.value }, Customer::id)
   })
}