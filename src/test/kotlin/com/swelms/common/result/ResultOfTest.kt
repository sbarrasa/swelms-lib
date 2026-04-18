package com.swelms.common.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ResultOfTest {
   @Test
   fun success() {
      val a = 10
      val b = 2
      val result = resultOf { a / b }
      assertTrue { result is Result.Success }
   }

   @Test
   fun fail() {
      val a = 10
      val b = 0
      val result = resultOf { a / b }
      assertTrue { result is Result.Fail }
   }
   @Test
   fun elvis() {
      val a = 10
      val b = 0
      val value = resultOf { a / b }.value ?: -1

      assertEquals(-1, value)
   }

   @Test
   fun orElseValue() {
      val a = 10
      val b = 0
      val value = resultOf { a / b }.valueOr { -1 }
      assertEquals(-1, value)
   }

   @Test
   fun orElseMessage() {
      val a = 10
      val b = 0
      val value = resultOf { a / b }.valueOr { "ERROR" }
      assertEquals("ERROR", value)
   }

   @Test
   fun orElseNull() {
      val a = 10
      val b = 0

      val value = resultOf { a / b }.valueOr { null }
      assertNull(value)
   }

   @Test
   fun orElseErrorMessage() {
      val a = 10
      val b = 0
      val value = resultOf { a / b } valueOr { it.error.message }
      assertEquals("/ by zero", value)
   }

   @Test
   fun orElseError() {
      val a = 10
      val b = 0
      val value = resultOf { a / b } valueOr { it.error }
      assertTrue { value is Exception }
   }
}
