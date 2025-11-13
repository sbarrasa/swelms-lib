package com.bank.repository

import com.bank.dto.customer.Customer
import com.sbarrasa.repository.exposed.ExposedRepository
import com.sbarrasa.util.objectcopy.*

object ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { entity -> entity.copyTo(Customer()) },
   mapToEntity = { dto, entity -> dto.copyTo(entity) }
)
