package com.bank

import com.bank.ktor.configModule
import com.swelms.common.locale.Locale
import com.swelms.common.locale.localeText
import com.swelms.common.locale.printAll
import com.swelms.domain.id.cuit.Cuit
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
   println(Cuit("20240614708").localeText("INVALID_LENGTH"))
   println(Cuit.EntityType.PERSON.description)


   embeddedServer(Netty, env).start(wait = true)

}





