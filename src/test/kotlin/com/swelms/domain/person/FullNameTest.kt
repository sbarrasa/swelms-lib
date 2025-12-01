package com.swelms.domain.person

import com.swelms.common.locale.localeText
import com.swelms.domain.person.name.FullName
import com.swelms.domain.person.name.FullNameFormatter
import com.swelms.domain.person.name.NamePart
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
      val error = assertFailsWith<IllegalArgumentException> {
         FullName("SoloNombre")
      }
      assertContains(error.message ?: "", localeText("INVALID_FORMAT"))
   }

   @Test
   fun legalOrderFormatter() {
      val fullName = FullName("Gomez García, Juan José")
      assertEquals("Gomez García, Juan José", fullName.format(FullName.Formatter.legalOrder))
   }

   @Test
   fun fullOrderFormatter() {
      val fullName = FullName("Gomez García, Juan José")
      assertEquals("Juan José Gomez García", fullName.format(FullName.Formatter.fullOrder))
   }

   @Test
   fun first_LastsFormatter() {
      val fullName = FullName("Gomez García, Juan José")
      assertEquals("Juan Gomez García", fullName.format(FullName.Formatter.first_lasts))
   }

   @Test
   fun fullNameConstructors() {
      val fromString = FullName("Garcia, Jose Maria")
      val fromStrings = FullName("Garcia", "Jose Maria")
      val fromNameParts = FullName(NamePart("Garcia"), NamePart("Jose Maria"))

      listOf(fromString, fromStrings, fromNameParts).forEach { fn ->
         assertEquals("Jose Maria", fn.givenNames.text)
         assertEquals("Garcia", fn.lastNames.text)
         assertEquals(listOf("Jose", "Maria", "Garcia"), fn.list)
      }
   }

   @Test
   fun initialsTestFormat() {
      val formatter: FullNameFormatter = {"${it.initials[0]}.${it.initials[1]}.${it.initials[2]}.${it.lastNames}"}
      val fullName = FullName("Tolkien", "John Ronald Reuel")
      assertEquals("J.R.R.Tolkien", fullName.format(formatter))
   }

   @Test
   fun accessByIndex() {
      val fullName = FullName("Barrasa, Sebastian Gabriel")
      assertEquals("Sebastian", fullName[0])
      assertEquals("Barrasa", fullName[2])
   }

}
