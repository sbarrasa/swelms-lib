package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class FactorialTest {
   @Test
   fun test6(){
      assertEquals(6, factorial(3))
   }

   @Test
   fun testNegative(){
      assertFails { factorial(-1) }
   }

   @Test
   fun testOverflow(){
      assertFails { factorial(21) }
   }
}

