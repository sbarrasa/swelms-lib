package com.swelms.common.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
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
   fun tryGetOrAny() {
      val a = 10
      val b = 0
      val value = tryGet { a / b } orElse { "ERROR" }
      assertEquals("ERROR", value)
   }

   @Test
   fun tryGetFail() {
      val a = 10
      val b = 0

      val value = tryGet { a / b } orElse { null }
      assertNull(value)
   }

   @Test
   fun tryGetSuccess() {
      val a = 10
      val b = 2
      val value = tryGet { a / b } orElse { null }
      assertEquals(5, value)
   }


   @Test
   fun tryGetIsError() {
      val a = 10
      val b = 0
      val result= tryGet { a / b }
      assertTrue { result is Result.Error }
   }

   @Test
   fun tryGetIsSuccess() {
      val a = 10
      val b = 2

      val result = tryGet { a / b }
      assertTrue { result is Result.Success }
   }


   @Test
   fun tryGetOnError(){
      val a = 10
      val b = 0
      var errorMsg: String? = null
      tryGet { a / b } onError { errorMsg = it.message }
      assertNotNull(errorMsg)
   }


}
