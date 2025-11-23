package com.bank

import com.bank.ktor.routes.codesRoutes
import com.bank.ktor.routes.customerProductsRoutes
import com.bank.ktor.routes.customerRoutes
import com.bank.ktor.config.configDatabase
import com.bank.ktor.config.configLocale
import com.bank.ktor.config.configLog
import com.bank.ktor.config.configSerialization
import com.bank.ktor.config.configStatusPages
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
   val env = applicationEngineEnvironment {
      config = HoconApplicationConfig(ConfigFactory.load("application.conf"))
      module {
         configLocale()
         configStatusPages()
         configSerialization()
         configDatabase()
         customerRoutes()
         codesRoutes()
         customerProductsRoutes()
         configLog()
      }
      connector {
         port = 8080
      }
   }

   embeddedServer(Netty, env).start(wait = true)

}




