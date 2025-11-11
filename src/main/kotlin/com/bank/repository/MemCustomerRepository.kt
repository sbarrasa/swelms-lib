package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.repository.IntMemRepository
import com.sbarrasa.util.objectcopy.copyTo


class MemCustomerRepository : CustomerRepository, IntMemRepository<Customer>() {
   override fun update(id: Int?, dto: Customer): Customer {
      val currentEntity = get(id)
      dto.copyTo(currentEntity)
      return super.update(id, currentEntity)
   }

}