package com.bank.database

import com.swelms.domain.person.Gender
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

object CustomersTable : Table("customers") {
   val id = integer("id").autoIncrement()
   override val primaryKey = PrimaryKey(id)

   val legalName = varchar("legal_name", 50)
   val cuit = varchar("cuit", 11)
   val birthDay = date("birth_day").nullable()
   val gender = enumerationByName("gender", 1, Gender::class).nullable()
}