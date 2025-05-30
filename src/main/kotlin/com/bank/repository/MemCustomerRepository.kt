package com.bank.repository

import com.bank.model.customer.Customer
import com.bank.service.CustomerMapper
import com.sbarrasa.repository.IntMemRepository


class MemCustomerRepository: CustomerRepository, IntMemRepository<Customer>(){
    override fun update(id: Int?, dto: Customer): Customer {
            val currentEntity = get(id)
            CustomerMapper.map(dto, currentEntity)
            return super.update(id, currentEntity)
    }

}