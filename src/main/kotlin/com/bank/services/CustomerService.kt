package com.bank.database

import com.bank.model.customer.Customer
import com.swelms.common.locale.Locale
import com.swelms.common.locale.localeText
import com.swelms.common.locale.replaceSlots
import com.swelms.domain.person.name.FullName
import com.swelms.domain.id.cuit.Cuit
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
         .firstOrNull() ?: throw NoSuchElementException(localeText("CUSTOMER_NOT_FOUND").replaceSlots(id))
   }


   fun add(customer: Customer): Customer = transaction {
      val id = CustomersTable.insert { customer.toRow(it) } get CustomersTable.id
      get(id)
   }

   fun update(id: Int, customer: Customer): Customer = transaction {
         val currentCustomer = get(id)
         customer.copyTo(currentCustomer)

         CustomersTable.update({ CustomersTable.id eq id })
                           { currentCustomer.toRow(it) }
         currentCustomer

      }


   fun delete(id: Int): Customer = transaction {
      val customer = get(id)
      CustomersTable.deleteWhere { CustomersTable.id eq id }
      customer
   }
}

fun Customer.copyTo(target: Customer) = target.copy(
      fullName = this.fullName ?: target.fullName,
      birthDay = this.birthDay ?: target.birthDay,
      cuit = this.cuit ?: target.cuit,
      gender = this.gender ?: target.gender
   )



fun Customer.toRow(stmt: UpdateBuilder<*>) {
   stmt[CustomersTable.legalName] = fullName?.text ?: ""
   stmt[CustomersTable.cuit] = cuit?.value ?: ""
   stmt[CustomersTable.birthDay] = birthDay
   stmt[CustomersTable.gender] = gender
}

fun ResultRow.toCustomer() = Customer(
      id = this[CustomersTable.id],
      fullName = FullName(this[CustomersTable.legalName]),
      birthDay = this[CustomersTable.birthDay],
      cuit = Cuit(this[CustomersTable.cuit]),
      gender = this[CustomersTable.gender]
   )
