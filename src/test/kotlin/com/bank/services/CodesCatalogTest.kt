package com.bank.services

import com.bank.locale.lang_es
import com.swelms.common.locale.Locale
import kotlin.test.*

class CodesCatalogTest {
   init {
      Locale.registerConfigs(lang_es)
      Locale.lang = "es"
   }

   @Test
   fun getEntries() {
      Codes.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}