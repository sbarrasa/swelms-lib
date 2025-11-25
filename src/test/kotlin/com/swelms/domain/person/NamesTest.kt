package com.swelms.domain.person

import kotlin.test.*

class NamesTest {

   @Test
   fun cleanWorks() {
      val input = "D'Alezandro! @# García"
      val expected = "D'Alezandro García"
      assertEquals(expected, Names.clean(input))
   }

   @Test
   fun isValidTrue() {
      val validNames = listOf(
         "Jose Maria",
         "D'Arcy",
         "Elodie Dupont",
         "Łukasz Kowalski",
         "Mário de Souza",
         "Paragüero Garçzon"
      )

      validNames.forEach { name ->
         assertTrue(Names.isValid(name))
      }
   }

   @Test
   fun isValidFalse() {
      val invalidNames = listOf(
         "Jose123",
         "Anna!",
         "O'Connor@",
         "Mário#de Souza",
         "Sebastian    gabriel"
      )
      invalidNames.forEach { name ->
         assertFalse(Names.isValid(name))
      }
   }



   @Test
   fun validateValid() {
      Names.validate("D'Arcy Lopez")
      Names.validate("José María")
      Names.validate("Łukasz")
   }

   @Test
   fun validateInvalid() {
      assertFailsWith<IllegalArgumentException> { Names.validate("D'Arcy123") }
      assertFailsWith<IllegalArgumentException> { Names.validate("Mario#") }
      assertFailsWith<IllegalArgumentException> { Names.validate("José     María") }

   }


}
