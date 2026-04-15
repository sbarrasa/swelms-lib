package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals


class CaseTest {
   @Test
   fun upperString(){
      val str = "HoLa"
      assertEquals("HOLA", Case.UPPER.applyTo(str))
   }

   @Test
   fun lowerString(){
      val str = "HoLa"
      assertEquals("hola", Case.LOWER.applyTo(str))
   }

   @Test
   fun upperChar(){
      val char = 'h'
      assertEquals('H', Case.UPPER.applyTo(char))
   }

   @Test
   fun lowerChar(){
      val char = 'h'
      assertEquals('h', Case.LOWER.applyTo(char))
   }

}