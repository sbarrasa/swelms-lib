package com.bank.database

import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date


object CustomerProductsTable : IntIdTable("customer_products") {
   val customerId = integer("customer_id").references(CustomersTable.id)
   val productType = varchar("product_type", 2)
   val cbu = varchar("cbu", CBU.SIZE).nullable()
   val currency = enumerationByName("currency", 3, Currency::class).nullable()
   val creditLimit = double("credit_limit").nullable()
   val cardBrand = enumerationByName("card_brand", 4, CardBrand::class).nullable()
   val cardNumber = varchar("card_number", 16).nullable()
   val expirationDate = date("expiration_date").nullable()
   val cardTier = varchar("card_tier", 10).nullable()
}