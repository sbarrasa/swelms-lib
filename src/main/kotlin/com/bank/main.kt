package com.bank

import com.bank.application.module
import com.sbarrasa.common.locale.Locale
import com.sbarrasa.common.system.*
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger("Application")

fun main(args: Array<String>) {
   val env = applicationEngineEnvironment {
      config = HoconApplicationConfig(ConfigFactory.load("application.conf"))
      module {
         module()
      }
      connector {
         port = 8080
      }
   }

   Locale
      .apply {rootPackage = "com.bank.locale"
              lang = SysProp["lang"] }
      .also {log.info("Language: ${it.lang}") }
      .load()

   embeddedServer(Netty, env).start(wait = true)

}




