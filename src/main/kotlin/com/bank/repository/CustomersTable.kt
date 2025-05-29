package com.bank.repository

import com.bank.model.customer.Gender
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

object CustomersTable : IntIdTable("customers") {
    val firstName = varchar("first_name", 50)
    val lastName = varchar("last_name", 50)
    val birthDay = date("birth_day")
    val gender = enumerationByName("gender", 1, Gender::class)
}