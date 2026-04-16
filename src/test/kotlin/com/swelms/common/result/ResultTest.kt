package com.swelms.common.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ResultTest {
   @Test
   fun success() {
      val ok = Result.Success(10)
      assertEquals(10, ok.value)

   }
   @Test
   fun error() {
      val fail = Result.Fail<Any>(RuntimeException("error"))
      assertEquals("error", fail.error.message)
   }

   @Test
   fun destructuringError(){
      val fail = Result.Fail(RuntimeException("error"), 10)

      val (error, value) = fail
      assertEquals(10, value)
      assertTrue { error is RuntimeException }
   }

   @Test
   fun destructuringSuccess(){
      val success = Result.Success(10)

      val (value) = success
      assertEquals(10, value)
   }

   @Test
   fun toKotlinSuccess() {
      val result = Result.Success(10).toKotlinResult()
      assertTrue(result.isSuccess)
      assertEquals(10, result.getOrNull())
   }

   @Test
   fun toKotlinFail() {
      val result = Result.Fail<Int>(RuntimeException("error")).toKotlinResult()
      assertTrue(result.isFailure)
      assertEquals("error", result.exceptionOrNull()?.message)
   }

   @Test
   fun fromKotlinSuccess() {
      val result = runCatching { 10 }.fromKotlinResult()
      assertTrue(result is Result.Success)
      assertEquals(10, result.value)
   }

   @Test
   fun fromKotlinFail() {
      val result = runCatching<Int> { error("boom") }.fromKotlinResult()
      assertTrue(result is Result.Fail)
      assertEquals("boom", result.error.message)
   }
}
