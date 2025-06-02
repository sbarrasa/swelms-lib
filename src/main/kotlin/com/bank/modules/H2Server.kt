package com.bank.modules

import org.h2.server.TcpServer
import org.h2.tools.Server

object H2Server : Server(
   TcpServer(),
   "-tcp",
   "-tcpAllowOthers",
   "-tcpPort",
   "9092"
)
