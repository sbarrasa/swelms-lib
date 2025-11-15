package com.bank.repository

import com.bank.dto.customer.Customer
import com.sbarrasa.repository.IntMemRepository
import com.sbarrasa.util.objectcopy.copyTo


object MemCustomerRepository : CustomerRepository, IntMemRepository<Customer>() {
   override fun update(id: Int?, dto: Customer): Customer {
      val currentEntity = get(id)
      dto.copyTo(currentEntity, ignoreNulls = true)
      currentEntity.id = id //preservar el id
      return currentEntity
   }

}