package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class tryRunTest {
   @Test
   fun tryRunSuccess() {
      val a = 10
      val b = 2
      val result = tryRun { a / b }
      assertTrue(result is Result.Success)
   }

   @Test
   fun tryRunError() {
      val a = 10
      val b = 0

      val result = tryRun {
         a / b
      } onError {
         println(it)
      }
      assertTrue(result is Result.Error)
   }


   @Test
   fun tryRunWhen() {
      val a = 10
      val b = 0

      val test = when(tryRun { a / b }){
         is Result.Success -> "Ok"
         is Result.Error -> "Error"
      }

      assertEquals("Error", test)
   }



}