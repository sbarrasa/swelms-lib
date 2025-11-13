package com.bank.repository

import com.bank.config.DBClient
import org.slf4j.LoggerFactory

object RepositoryFactory {
   private val log = LoggerFactory.getLogger(this::class.simpleName)

   enum class Types {
      MEM, EXPOSED
   }


   fun get(type: Types): CustomerRepository {
      log.info("Repository type: $type")
      return when (type) {
         Types.MEM -> MemCustomerRepository
         Types.EXPOSED -> {
            DBClient.init(CustomersTable)
            ExposedCustomerRepository
         }
      }
   }

   fun get(typeStr: String?): CustomerRepository {
      return get(Types.valueOf(typeStr ?: Types.MEM.name))
   }
}