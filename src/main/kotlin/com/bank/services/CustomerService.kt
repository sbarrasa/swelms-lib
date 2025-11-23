package com.bank.database

import com.bank.model.customer.Customer
import com.sbarrasa.domain.person.FullName
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction



object CustomerService {

   fun getAll(): List<Customer> = transaction {
      val customers = CustomersTable.selectAll()

      customers.mapNotNull { it.toCustomer() }
   }

   fun get(id: Int): Customer = transaction {
      CustomersTable.selectAll()
         .where { CustomersTable.id eq id }
         .map { it.toCustomer() }
         .firstOrNull() ?: throw NoSuchElementException("Customer $id not found")
   }


   fun add(customer: Customer): Customer = transaction {
      val id = CustomersTable.insertAndGetId { customer.toRow(it) }.value
      get(id)
   }

   fun update(id: Int, customer: Customer): Customer = transaction {
      CustomersTable.update({ CustomersTable.id eq id })
         { customer.toRow(it) }
      get(id)
   }

   fun delete(id: Int): Customer = transaction {
      val customer = get(id)
      CustomersTable.deleteWhere { CustomersTable.id eq id }
      customer
   }
}

fun Customer.toRow(stmt: UpdateBuilder<*>) {
   stmt[CustomersTable.legalName] = fullName?.text ?: ""
   stmt[CustomersTable.cuit] = cuit?.value ?: ""
   stmt[CustomersTable.birthDay] = birthDay
   stmt[CustomersTable.gender] = gender
}

fun ResultRow.toCustomer() = Customer(
      id = this[CustomersTable.id].value,
      fullName = FullName(this[CustomersTable.legalName]),
      birthDay = this[CustomersTable.birthDay],
      gender = this[CustomersTable.gender]
   )
