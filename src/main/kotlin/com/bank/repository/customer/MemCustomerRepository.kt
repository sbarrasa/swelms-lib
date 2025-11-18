package com.bank.repository.customer

import com.bank.model.customer.Customer
import com.sbarrasa.id.generators.IntIdGen
import com.sbarrasa.objectcopy.copyTo
import com.sbarrasa.repository.MemRepository

object MemCustomerRepository : CustomerRepository, MemRepository<Int, Customer>(IntIdGen()) {
   override fun update(id: Int, dto: Customer): Customer {
      val currentEntity = get(id)
      dto.copyTo(currentEntity, ignoreNulls = true)
      currentEntity.id = id //preservar el id
      return currentEntity
   }

}