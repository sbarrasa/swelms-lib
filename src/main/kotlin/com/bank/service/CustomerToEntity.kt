package com.bank.service

import com.bank.model.customer.Customer
import com.bank.repository.CustomerEntity
import com.sbarrasa.util.ObjectMapper

object CustomerToEntity: ObjectMapper<Customer, CustomerEntity>({
    bindAll(Customer::class, CustomerEntity::class)
})