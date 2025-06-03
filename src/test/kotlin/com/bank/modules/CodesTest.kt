package com.bank.modules

import com.bank.model.product.factory.ProductTypes
import kotlin.test.*

class CodesTest {
   @Test
   fun getEntries() {
      ProductTypes.init()
      Codes.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}