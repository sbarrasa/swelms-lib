package com.sbarrasa.person

import kotlin.test.*

class NameTest {

   @Test
   fun createWithNamesAndLastNames() {
      val name = Name("Sebastian Gabriel", "Barrasa Rabinovich")
      assertEquals("Sebastian Gabriel", name.names)
      assertEquals("Barrasa Rabinovich", name.lastNames)
      assertEquals("Sebastian Gabriel Barrasa Rabinovich", name.fullNameFormat())
   }

   @Test
   fun createWithLegalName() {
      val name = Name("Barrasa Rabinovich, Sebastian Gabriel")
      assertEquals("Sebastian Gabriel", name.names)
      assertEquals("Barrasa Rabinovich", name.lastNames)
      assertEquals("Sebastian Gabriel Barrasa Rabinovich", name.toString())
   }

   @Test
   fun indexAccess() {
      val name = Name("Sebastian Gabriel", "Barrasa Rabinovich")
      assertEquals("Sebastian", name[0])
      assertEquals("Gabriel", name[1])
      assertEquals("Barrasa", name[2])
   }

   @Test
   fun correctSize() {
      val name = Name("Sebastian Gabriel", "Barrasa")
      assertEquals(3, name.size)
   }

   @Test
   fun splitTrimsSpaces() {
      val name = Name("  Sebastian   Gabriel  ", "  Barrasa   ")
      assertEquals(listOf("Sebastian", "Gabriel"), name.nameList)
      assertEquals(listOf("Barrasa"), name.lastNameList)
   }

   @Test
   fun toStringReturnsFullName() {
      val name = Name("Sebastian", "Barrasa")
      assertEquals("Sebastian Barrasa", name.toString())
   }

   @Test
   fun createWithNames() {
      val name = Name("Barrasa")
      assertEquals("Barrasa", name.lastNames)
      assertEquals("", name.names)
      assertEquals("Barrasa", name.fullNameFormat())
   }

}
