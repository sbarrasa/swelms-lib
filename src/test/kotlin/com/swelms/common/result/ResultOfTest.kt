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
      val value = (resultOf { a / b } orElse { -1 }).value
      assertEquals(-1, value)
   }

   @Test
   fun orElseMessage() {
      val a = 10
      val b = 0
      val value = (resultOf { a / b } orElse { "ERROR" }).value
      assertEquals("ERROR", value)
   }

   @Test
   fun orElseNull() {
      val a = 10
      val b = 0

      val value = (resultOf { a / b } orElse { null }).value
      assertNull(value)
   }

   @Test
   fun orElseErrorMessage() {
      val a = 10
      val b = 0
      val result = resultOf { a / b } orElse { it.error.message }
      val value = result.value
      assertEquals("/ by zero", value)
   }

   @Test
   fun orElseError() {
      val a = 10
      val b = 0
      val result = resultOf { a / b } orElse { it.error }
      val value = result.value
      assertTrue { value is Exception }
   }

   @Test
   fun component(){
      val a = 10
      val b = 0
      val (value) = resultOf { a / b } orElse { "ERROR" }
      assertEquals("ERROR", value)
   }

   @Test
   fun onFail() {
      val a = 10
      val b = 0
      val c = -1
      val r = resultOf { a / b } orElse { a / c }
      assertTrue(r is Result.Success)
   }

   @Test
   fun onFailPipeline() {
      val r = resultOf { "hola mundo" }
         .orElse { error("error1") }
         .orElse { error("error2") }

      assertTrue(r is Result.Success)
      assertEquals("hola mundo", r.value)
   }
}
