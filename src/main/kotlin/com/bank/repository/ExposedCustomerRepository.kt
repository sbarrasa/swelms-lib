package com.bank.repository

import com.bank.dto.customer.Customer
import com.sbarrasa.person.Name
import com.sbarrasa.repository.exposed.ExposedRepository

object ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { entity ->
      Customer(id = entity.id.value,
         legalName = Name(entity.legalName),
         cuit = entity.cuit,
         birthDay = entity.birthDay,
         gender = entity.gender)
              },
   mapToEntity = { dto, entity -> entity.apply {
         legalName = dto.legalName!!.legalNameFormat()
         birthDay = dto.birthDay
         gender = dto.gender
         cuit = dto.cuit!!
      }
   }
)
