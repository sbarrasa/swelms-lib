package com.sbarrasa.bank.service

import com.sbarrasa.bank.entities.customer.Customer
import com.sbarrasa.bank.repository.CustomerRepository

class CustomerService(private val repo: CustomerRepository) {

    fun update(id: Int, customer: Customer): Customer {
      val currentCustomer = repo.getById(id)
      CustomerMapper.map(customer, currentCustomer)
      return repo.update(currentCustomer)
    }

    fun getAll(): List<Customer> {
        return repo.getAll()
    }

    fun getById(id: Int): Customer {
        return repo.getById(id)
    }

    fun add(customer: Customer): Any {
        return repo.add(customer)
    }

    fun delete(id: Int): Customer {
        val customer = repo.getById(id)
        repo.delete(id)
        return customer
    }
}