package com.bank.repository

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CustomerEntity(id: EntityID<Int>) : IntEntity(id) {
   companion object : IntEntityClass<CustomerEntity>(CustomersTable)
   var legalName by CustomersTable.legalName

   var cuit by CustomersTable.cuit
   var birthDay by CustomersTable.birthDay
   var gender by CustomersTable.gender
}
