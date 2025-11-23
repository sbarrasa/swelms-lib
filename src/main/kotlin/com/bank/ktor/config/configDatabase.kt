package com.bank.ktor.config

import com.bank.database.customer.CustomerProductsTable
import com.bank.database.customer.CustomersTable
import io.ktor.server.application.Application
import io.ktor.server.application.log
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils

fun Application.configDatabase() {
   val dbServerKey = System.getenv("DB_SERVER") ?: "h2Embedded"
   val config = environment.config.config("db.$dbServerKey")

   Database.connect(
      url = config.property("url").getString(),
      driver = config.property("driver").getString(),
      user = config.property("user").getString(),
      password = config.property("password").getString()
   )
   log.info("Database: ${dbServerKey}")

   transaction {
      SchemaUtils.create(CustomersTable, CustomerProductsTable)
      log.info("Schemas ok")
   }

}