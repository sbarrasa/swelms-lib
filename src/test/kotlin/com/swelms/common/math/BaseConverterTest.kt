package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals

class BaseConverterTest {

   @Test
   fun testSigned() {
      assertEquals("FF", 255.toBase(16))
      assertEquals("-2A", (-42).toBase(16))
      assertEquals("1111011", 123.toBase(2))
      assertEquals("12", 10.toBase(8))
      assertEquals("7B", 123.toBase(16))
   }

   @Test
   fun testBases() {
      assertEquals("1111011", 123.toBase(2))
      assertEquals("173", 123.toBase(8))
      assertEquals("7B", 123.toBase(16))
      assertEquals("3F", 123.toBase(36))
      assertEquals("1111111111", 10.toBase(1))
      assertEquals("1010", 10.toBase(2))

   }
}
