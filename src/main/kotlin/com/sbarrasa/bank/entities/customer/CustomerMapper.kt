package com.sbarrasa.bank.entities.customer

import com.sbarrasa.util.ObjectMapper

class CustomerMapper: ObjectMapper<Customer, Customer>({
    bindAll(Customer::class, Customer::class)
})