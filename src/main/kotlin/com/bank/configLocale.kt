package com.bank

import com.swelms.common.locale.Locale
import io.ktor.server.application.Application
import io.ktor.server.application.log

fun configLocale() {
   val lang = System.getenv("lang")
   Locale.rootPackage = "com.bank.locale"
   Locale.lang = lang
   println("lang=$Locale.lang")
}
