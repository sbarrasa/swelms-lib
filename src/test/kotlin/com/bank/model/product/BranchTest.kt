package com.bank.model.product

import kotlin.test.Test
import kotlin.test.assertEquals

class BranchTest {

   @Test
   fun asMap() {
      println(Branch.asMap())
   }

   @Test
   fun descAmex() {
      assertEquals("American Express", Branch.AMEX.description)
   }
}