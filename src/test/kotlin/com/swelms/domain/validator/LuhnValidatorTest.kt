package com.swelms.domain.validator

import kotlin.test.Test
import kotlin.test.assertEquals

class LuhnValidatorTest {

   @Test
   fun computeWithListTest() {
      val digits = listOf(1, 2, 3, 4,5,6,7)
      assertEquals(4, LuhnValidator("Error").compute(digits))
   }

   @Test
   fun computeWithStringTest() {
      val number = "7992739871"
      assertEquals(3, LuhnValidator("Error").compute(number))
   }

}