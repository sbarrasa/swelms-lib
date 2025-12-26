package com.swelms.common

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ResultTest {
   @Test
   fun succes() {
      val ok = Result.Success(10)
      assertEquals(10, ok.value)

   }
   @Test
   fun error() {
      val fail = Result.Error<Any>(RuntimeException("error"))
      assertEquals("error", fail.error.message)
   }

   @Test
   fun destructuringError(){
      val fail = Result.Error(RuntimeException("error"), 10)

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
}