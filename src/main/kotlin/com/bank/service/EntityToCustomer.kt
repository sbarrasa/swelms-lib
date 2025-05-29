package com.bank.service

import com.bank.model.customer.Customer
import com.bank.repository.CustomerEntity
import com.sbarrasa.util.ObjectMapper

object EntityToCustomer: ObjectMapper<CustomerEntity, Customer>({
    bindAll(CustomerEntity::class, Customer::class)
    bind({it.id.value}, Customer::id)
})