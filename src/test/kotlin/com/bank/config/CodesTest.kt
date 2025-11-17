package com.bank.config

import kotlin.test.*

class CodesTest {
   @Test
   fun getEntries() {
      CodesCatalog.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}