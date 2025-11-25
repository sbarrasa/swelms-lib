package com.bank.locale

import com.bank.model.products.structure.Currency
import kotlin.test.Test
import com.swelms.common.locale.*

class RegionalTest {
   @Test
   fun test() {
      Locale.rootPackage = "com.bank.locale"

      val regionals = listOf("ar", "us", null)
      regionals.forEach {
         Locale.regional = it
         val currency = Locale.config<Currency>("CURRENCY")
         val dateFormat = Locale.config<String>("DATE_FORMAT")

         println(it)
         println("Currency: $currency")
         println("Date Format: $dateFormat")
      }



   }
}