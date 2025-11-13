package com.bank.config

import com.bank.dto.product.factory.ProductFactory
import kotlin.test.*

class CodesTest {
   @Test
   fun getEntries() {
      ProductFactory.init()
      CodesCatalog.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}