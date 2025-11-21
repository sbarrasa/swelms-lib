package com.sbarrasa.domain.person

import kotlin.test.*

class NameUtilsTest {

   @Test
   fun cleanWorks() {
      val input = "D'Alezandro! @# García"
      val expected = "D'Alezandro García"
      assertEquals(expected, NameUtils.clean(input))
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
         assertTrue(NameUtils.isValid(name))
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
         assertFalse(NameUtils.isValid(name))
      }
   }

   @Test
   fun splitThrows() {
      assertFailsWith<IllegalArgumentException> {
         NameUtils.split("SoloNombre")
      }
      assertFailsWith<IllegalArgumentException> {
         NameUtils.split("Apellido1, Apellido2, Nombre")
      }
   }

   @Test
   fun simpleFullNameWorks() {
      val fullName = "Garcia, Jose Maria"
      val parts = BasicFullName.create(fullName)
      assertEquals("Jose Maria", parts.givenNames.text)
      assertEquals("Garcia", parts.lastNames.text)
   }

   @Test
   fun validateSimpleValid() {
      NameUtils.validate("D'Arcy Lopez")
      NameUtils.validate("José María")
      NameUtils.validate("Łukasz")
   }

   @Test
   fun validateSimpleInvalid() {
      assertFailsWith<IllegalArgumentException> { NameUtils.validate("D'Arcy123") }
      assertFailsWith<IllegalArgumentException> { NameUtils.validate("Mario#") }
   }

   @Test
   fun validateFullNameValid() {
      NameUtils.validate("Garcia, José María", isFullName = true)
      NameUtils.validate("D'Alezandr, Łukasz", isFullName = true)
   }

   @Test
   fun validateFullNameInvalidFormat() {
      assertFailsWith<IllegalArgumentException> { NameUtils.validate("SoloNombre", isFullName = true) }
      assertFailsWith<IllegalArgumentException> { NameUtils.validate("Apellido1, Apellido2, Nombre", isFullName = true) }
   }


}
