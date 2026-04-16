package com.swelms.common.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TryGetTest {
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
      val value = tryGet { a / b } orElse { -1 }
      assertEquals(-1, value)
   }

   @Test
   fun tryGetOrMsg() {
      val a = 10
      val b = 0
      val value = tryGet { a / b } orElse { "ERROR" }
      assertEquals("ERROR", value)
   }

   @Test
   fun tryGetNull() {
      val a = 10
      val b = 0

      val value = tryGet { a / b } orElse { null }
      assertNull(value)
   }

   @Test
   fun tryGetSuccess() {
      val a = 10
      val b = 2
      val result = tryGet { a / b }
      assertTrue { result is Result.Success }
   }

   @Test
   fun tryGetError() {
      val a = 10
      val b = 0
      val result = tryGet { a / b }
      assertTrue { result is Result.Error }
   }

}
