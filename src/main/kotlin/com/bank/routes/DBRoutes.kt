package com.bank.routes

import com.bank.db.H2Server
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.h2.tools.Server

object DBRoutes {

   fun register(parent: Route) {
      parent.route("/db") {
         registerServerRoutes("web", H2Server.web)
         registerServerRoutes("tcp", H2Server.tcp)
      }
   }

   private fun Route.registerServerRoutes(
      name: String,
      server: Server
   ) {
      get("/$name/status") {
         call.respondText("$name server status: ${serverStatus(server)}")
      }

      post("/$name/start") {
         if (!server.isRunning(false)) server.start()
         call.respondText("$name server status: ${serverStatus(server)}")
      }

      post("/$name/stop") {
         if (server.isRunning(false)) server.stop()
         call.respondText("$name server status: ${serverStatus(server)}")
      }
   }

   private fun serverStatus(server: Server) =
      if (server.isRunning(true)) "running" else "stopped"


}