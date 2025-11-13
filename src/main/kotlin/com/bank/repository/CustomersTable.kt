package com.bank.repository

import com.bank.dto.customer.Gender
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

object CustomersTable : IntIdTable("customers") {
   val legalName = varchar("legal_name", 50)
   val cuit = varchar("cuit", 11)
   val birthDay = date("birth_day").nullable()
   val gender = enumerationByName("gender", 1, Gender::class).nullable()
}

