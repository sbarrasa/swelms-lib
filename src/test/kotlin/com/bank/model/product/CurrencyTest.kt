package com.bank.model.product

import com.sbarrasa.id.EnumDesc
import kotlin.test.Test


class CurrencyTest {
   @Test
   fun asMap() {
      println(EnumDesc(Currency::class).asMap())
   }
}