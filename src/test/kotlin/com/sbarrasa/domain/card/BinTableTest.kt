package com.sbarrasa.domain.card

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BinTableTest {

   @Test
   fun visaBinRange() {
      val bin = BinTable.get("4111111111111111")!!
      assertEquals(4, bin.range.first)
      assertEquals(4, bin.range.last)
      assertEquals(16, bin.cardNumberLength)
      assertEquals(CardBrand.VISA, bin.brand)
   }

   @Test
   fun amex34() {
      val bin = BinTable.get("340000000000000")!!
      assertEquals(34, bin.range.first)
      assertEquals(34, bin.range.last)
      assertEquals(15, bin.cardNumberLength)
      assertEquals(CardBrand.AMEX, bin.brand)
   }

   @Test
   fun unknownBin() {
      assertNull(BinTable.get("9999999999999999"))
   }

   @Test
   fun groupByBinLengthKeys() {
      val map = BinTable.groupByBinLength()
      assertTrue {  map.size>2}
   }

   @Test
   fun lengthRange() {
      val range = BinTable.lengthRange()
      assertEquals(14, range.first)
      assertEquals(18, range.last)
   }
}
