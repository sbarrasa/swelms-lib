package com.bank

import com.bank.ktor.configModule
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
   val env = applicationEngineEnvironment {
      config = HoconApplicationConfig(ConfigFactory.load("application.conf"))
      module {
         configModule()
      }
      connector {
         port = 8080
      }
   }

   configLocale()
   embeddedServer(Netty, env).start(wait = true)

}





