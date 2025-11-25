package com.swelms.domain.person

import kotlin.test.*

class NamePartTest {

   @Test
   fun namePartValid() {
      val part = NamePart("D'Arcy")
      assertEquals("D'Arcy", part.text)
   }

   @Test
   fun namePartInvalid() {
      assertFailsWith<IllegalArgumentException> {
         NamePart("D'Arcy123")
      }
   }

   @Test
   fun count() {
      val part = NamePart("María del Pilar")
      assertEquals(3, part.count)
   }
}
