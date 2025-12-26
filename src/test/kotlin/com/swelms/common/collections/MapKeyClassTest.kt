package com.swelms.common.collections

import com.swelms.domain.locale.Currency
import kotlin.test.Test
import kotlin.test.assertEquals


class MapKeyClassTest {

   @Test
   fun mapEnum(){
      val map = Currency.entries.associateWith { it.code }
      assertEquals(Currency::class, map.keyClass)
   }

   @Test
   fun map(){
      val map = mapOf(1 to "a", 2 to "b")
      assertEquals(Int::class, map.keyClass)
   }

}