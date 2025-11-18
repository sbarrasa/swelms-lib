package com.bank.repository.customer

import com.bank.model.customer.Customer
import com.sbarrasa.fiscal.cuit.Cuit
import com.sbarrasa.person.Name
import com.sbarrasa.repository.exposed.ExposedRepository

object ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity
) {

   override fun mapToDTO(entity: CustomerEntity) =
      Customer(
         id = entity.id.value,
         legalName = Name(entity.legalName),
         cuit = Cuit(entity.cuit),
         birthDay = entity.birthDay,
         gender = entity.gender
      )

    override fun mapToEntity(dto: Customer, entity: CustomerEntity) {
      entity.apply {
         legalName = dto.legalName!!.legalNameFormat()
         birthDay = dto.birthDay
         gender = dto.gender
         cuit = dto.cuit!!.value
      }

   }
}