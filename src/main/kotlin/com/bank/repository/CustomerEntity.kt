package com.bank.repository

import com.sbarrasa.fiscal.cuit.Cuit
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CustomerEntity(id: EntityID<Int>) : IntEntity(id) {
   companion object : IntEntityClass<CustomerEntity>(CustomersTable)

   var legalName by CustomersTable.legalName

   private var cuitStr by CustomersTable.cuit
   var cuit: Cuit
      get()=Cuit(cuitStr)
      set(value){
         this.cuitStr = value.toString()
      }
   var birthDay by CustomersTable.birthDay
   var gender by CustomersTable.gender
}
