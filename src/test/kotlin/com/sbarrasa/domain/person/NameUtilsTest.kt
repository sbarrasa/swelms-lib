package com.sbarrasa.domain.person

import kotlin.test.*

class NameUtilsTest {
   @Test
   fun clean() {
      assertEquals(LEGAL_NAME,
         NameUtils.clean(" Barrasa  *  Rabinovich, Sebastián 1234 Gabriel "))
   }

   @Test
   fun isValid() {
      assertTrue(NameUtils.isValid(LEGAL_NAME))
   }

   @Test
   fun notIsValid() {
      assertFalse(NameUtils.isValid(" Sebastián Gabriel "))
      assertFalse(NameUtils.isValid("Barrasa,, Sebastián"))
      assertFalse(NameUtils.isValid("Barrasa1, Sebastián"))
   }


}