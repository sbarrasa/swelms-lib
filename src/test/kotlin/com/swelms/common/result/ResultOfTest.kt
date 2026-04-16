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
      val value = resultOf { a / b }.valueOrElse { -1 }
      assertEquals(-1, value)
   }

   @Test
   fun orElseMessage() {
      val a = 10
      val b = 0
      val value = resultOf { a / b }.valueOrElse { "ERROR" }
      assertEquals("ERROR", value)
   }

   @Test
   fun orElseNull() {
      val a = 10
      val b = 0

      val value = resultOf { a / b }.valueOrElse { null }
      assertNull(value)
   }


}
