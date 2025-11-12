package com.sbarrasa.person

import kotlin.test.*

class NombrableTest {

   data class Persona(val name: Name) : Nombrable by name

   @Test
   fun delegationAllowsDirectAccess() {
      val persona = Persona(Name("Barrasa Rabinovich, Sebastian Gabriel"))
      assertEquals("Sebastian Gabriel", persona.names)
      assertEquals("Barrasa Rabinovich", persona.lastNames)
   }

   @Test
   fun stillAccessesInnerName() {
      val persona = Persona(Name("Barrasa Rabinovich, Sebastian Gabriel"))
      assertEquals("Sebastian Gabriel Barrasa Rabinovich", persona.name.fullNameFormat())
   }

   @Test
   fun independentDelegations() {
      val p1 = Persona(Name("Barrasa, Sebastian"))
      val p2 = Persona(Name("Rabinovich, Gabriel"))
      assertNotEquals(p1.names, p2.names)
      assertNotEquals(p1.lastNames, p2.lastNames)
   }
}
