package com.bank.repository.customer

import com.bank.model.customer.Customer
import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.person.FullName
import com.sbarrasa.repository.exposed.ExposedRepository

object ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity
) {

   override fun mapToDTO(entity: CustomerEntity) =
      Customer(
         id = entity.id.value,
         fullName = FullName(entity.legalName),
         cuit = Cuit(entity.cuit),
         birthDay = entity.birthDay,
         gender = entity.gender
      )

    override fun mapToEntity(dto: Customer, entity: CustomerEntity) {
      entity.apply {
         legalName = dto.fullName!!.text
         birthDay = dto.birthDay
         gender = dto.gender
         cuit = dto.cuit!!.value
      }

   }
}