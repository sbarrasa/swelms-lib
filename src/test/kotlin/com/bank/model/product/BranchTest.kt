package com.bank.model.product

import kotlin.test.Test
import kotlin.test.assertEquals
import com.sbarrasa.id.*

class BranchTest {

   @Test
   fun asMap() {
      println(EnumDesc.of<Branch>().asMap())
   }

   @Test
   fun descAmex() {
      assertEquals("American Express", Branch.AMEX.description)
   }
}