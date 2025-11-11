package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.exposed.repository.ExposedRepository
import com.sbarrasa.util.objectcopy.*

class ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { it.copyTo(Customer()) },
   mapToEntity = { dto, entity -> dto.copyTo(entity) }
)
