package com.sbarrasa.bank.repository

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

object Customers : IdTable<Int>() {
    override val id = integer("id").entityId()
    val name = varchar("name", 50)
    val lastName = varchar("last_name", 50)
    val birthDay = date("birth_day")
}