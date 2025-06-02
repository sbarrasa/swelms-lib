package com.bank.modules

import com.bank.repository.CustomersTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DBClient {
   fun init() {
      Database.connect(
         url = "jdbc:h2:tcp://localhost:9092/c:/develop/data/db;DB_CLOSE_DELAY=-1;",
         driver = "org.h2.Driver",
         user = "root",
         password = ""
      )

      transaction {
         SchemaUtils.create(CustomersTable)
      }
   }
}

