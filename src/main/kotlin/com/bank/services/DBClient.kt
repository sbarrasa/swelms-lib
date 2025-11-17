package com.bank.services

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.Table
import org.slf4j.LoggerFactory


object DBClient {
   private val log = LoggerFactory.getLogger(this::class.simpleName)

   fun init(vararg tables: Table) {
      Database.connect(
         url = "jdbc:h2:tcp://localhost:9092/c:/develop/data/db;DB_CLOSE_DELAY=-1",
         driver = "org.h2.Driver",
         user = "root",
         password = ""
      )

      log.info("Database connected")

      transaction {
         SchemaUtils.create(*tables)
         log.info("Tables created")
      }
   }
}

