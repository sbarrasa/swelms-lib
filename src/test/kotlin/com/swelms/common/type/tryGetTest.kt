package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue


class tryGetTest {
   @Test
   fun tryGetElvis() {
      val a = 10
      val b = 0
      val value = tryGet { a / b }.value ?: -1
      assertEquals(-1, value)
   }

   @Test
   fun tryGetOrElse() {
      val a = 10
      val b = 0
      val value = tryGet { a / b } orElse -1
      assertEquals(-1, value)
   }

   @Test
   fun tryGetOrAny() {
      val a = 10
      val b = 0
      val value = tryGet { a / b } orAny "ERROR"
      assertEquals("ERROR", value)
   }

   @Test
   fun tryGetFail() {
      val a = 10
      val b = 0

      val value = tryGet { a / b }.orElse { println(it.error); null }
      assertNull(value)
   }

   @Test
   fun tryGetSuccess() {
      val a = 10
      val b = 2
      val value = tryGet { a / b } orElse { println(it.error); null }
      assertEquals(5, value)
   }

   @Test
   fun tryGetAny() {
      val a = 10
      val b = 0
      val value = tryGet { a / b } orAny { it.error?.message }
      assertEquals("/ by zero", value)

      val a2 = 10
      val b2 = 2
      val value2 = tryGet { a2 / b2 } orAny { it.error?.message }
      assertEquals(5, value2)
   }

   @Test
   fun tryGetIsError() {
      val a = 10
      val b = 0
      val result= tryGet { a / b }
      assertTrue { result is Result.Error }
   }

   @Test
   fun tryGetIsValue() {
      val a = 10
      val b = 2

      val result = tryGet { a / b }
      assertTrue { result is Result.Success }
   }

   @Test
   fun tryGetWithDefault(){
      val a = 10
      val b = 0

      val value = tryGet { a / b } orElse {-1}
      assertEquals(-1, value)

      val a2 = 10
      val b2 = 2

      val value2 = tryGet { a2 / b2 } orElse {-1}
      assertEquals(5, value2)

   }
}