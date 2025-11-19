package com.sbarrasa.domain.person

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FullNameTest {

   @Test
   fun fromLegalNameSplits() {
      val n = FullName.from(LEGAL_NAME)
      assertEquals(NAMES, n.names)
      assertEquals(LAST_NAMES, n.lastNames)
   }

   @Test
   fun fullNameListCorrect() {
      val n = FullName(NAMES, LAST_NAMES)
      assertEquals(listOf("Sebastián", "Gabriel", "Barrasa", "Rabinovich"), n.fullNameList)
   }

   @Test
   fun validateThrowsInvalid() {
      assertFailsWith<IllegalArgumentException> {
         FullName("Invalid,Name,Test")
      }
   }

   @Test
   fun countCorrect() {
      val n = FullName(NAMES, LAST_NAMES)
      assertEquals(4, n.count)
   }

   @Test
   fun getIndexWorks() {
      val n = FullName(NAMES, LAST_NAMES)
      assertEquals("Sebastián", n[0])
      assertEquals("Barrasa", n[2])
   }


}
