package com.bank.application

import com.bank.database.customer.CustomerProductsTable
import com.bank.database.customer.CustomersTable
import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils

fun Application.configDatabase() {
   val dbServerKey = System.getenv("DB_SERVER") ?: "h2Embedded"
   val config = environment.config.config("ktor.db.$dbServerKey")

   Database.connect(
      url = config.property("url").getString(),
      driver = config.property("driver").getString(),
      user = config.property("user").getString(),
      password = config.property("password").getString()
   )

   transaction {
      SchemaUtils.create(CustomersTable, CustomerProductsTable)
   }

}