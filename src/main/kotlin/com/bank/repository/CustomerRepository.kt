package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.repository.Repository

interface CustomerRepository : Repository<Int?, Customer>