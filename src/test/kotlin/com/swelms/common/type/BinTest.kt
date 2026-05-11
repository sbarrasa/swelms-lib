package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BinTest {
   @Test
   fun eval() {
      assertEquals(1, Bin[true])
      assertEquals(0, Bin[false])
   }

   @Test
   fun not(){
      val b = !Bin
      assertEquals(1, b[false])
   }

   @Test
   fun toEither() {
      val b = Bin.toEither(false)
      assertTrue { b is Either.Left }
      assertEquals(0, b.value)
   }

}