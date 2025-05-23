package com.sbarrasa.bank.repository

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CustomerEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CustomerEntity>(Customers)
    var name by Customers.name
    var lastName by Customers.lastName
    var birthDay by Customers.birthDay
}







