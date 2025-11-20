package com.sbarrasa.domain.person

import kotlin.test.*

class FullNameTest {

   @Test
   fun fullNameParts() {
      val fullName = FullName("Garcia, Jose Maria")
      assertEquals("Jose Maria", fullName.givenNames.text)
      assertEquals("Garcia", fullName.lastNames.text)
      assertEquals(listOf("Jose", "Maria", "Garcia"), fullName.list)
   }


   @Test
   fun fullNameInvalidFormat() {
      assertFailsWith<IllegalArgumentException> {
         FullName("SoloNombre")
      }
      assertFailsWith<IllegalArgumentException> {
         FullName("Apellido1, Apellido2, Nombre")
      }
   }
}
