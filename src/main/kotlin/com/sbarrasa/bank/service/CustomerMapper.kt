package com.sbarrasa.bank.service

import com.sbarrasa.bank.entities.customer.Customer
import com.sbarrasa.util.ObjectMapper

object CustomerMapper: ObjectMapper<Customer, Customer>({
    bindAll(Customer::class, Customer::class)
})