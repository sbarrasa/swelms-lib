package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertTrue

class tryRunTest {
   @Test
   fun tryRunSuccess() {
      val a = 10
      val b = 2
      val result = tryRun { a / b }
      assertTrue(result is Res.Success)
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
      assertTrue(result is Res.Error)
   }



}