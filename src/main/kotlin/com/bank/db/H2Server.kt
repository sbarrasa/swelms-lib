package com.bank.db

import org.h2.tools.Server


object H2Server {

   val tcp: Server by lazy {
      Server.createTcpServer(
         "-tcp",
         "-tcpAllowOthers",
         "-tcpPort", "9092"
      )
   }

   val web: Server by lazy {
      Server.createWebServer(
         "-web",
         "-webAllowOthers",
         "-webPort", "8082"
      )
   }
}
