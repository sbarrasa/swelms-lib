package com.bank.repository.customer

import com.bank.model.products.structure.CardBranch
import com.bank.model.products.structure.Currency
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date


object CustomerProductsTable : IntIdTable("customer_products") {
   val customerId = integer("customer_id").references(CustomersTable.id)
   val productType = varchar("product_type", 2)
   val cbu = varchar("cbu", 22).nullable()
   val currency = enumerationByName("currency", 3, Currency::class).nullable()
   val creditLimit = double("credit_limit").nullable()
   val cardBranch = enumerationByName("branch", 4, CardBranch::class).nullable()
   val cardNumber = varchar("card_number", 16).nullable()
   val expirationDate = date("expiration_date").nullable()
   val tier = varchar("tier", 50).nullable()
}