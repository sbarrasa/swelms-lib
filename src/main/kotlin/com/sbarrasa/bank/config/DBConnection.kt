package com.sbarrasa.bank.config

import com.sbarrasa.bank.repository.Customers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.Database

object DBConnection {
    fun init() {
        Database.connect(
            url = "jdbc:h2:file:/develop/data/db;DB_CLOSE_DELAY=-1;",
            driver = "org.h2.Driver",
            user = "root",
            password = ""
        )

        transaction {
            SchemaUtils.create(Customers)
        }
    }
}