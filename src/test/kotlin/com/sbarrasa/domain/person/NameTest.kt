package com.sbarrasa.domain.person

import kotlin.test.*

class NameTest {


   @Test
   fun invalid(){
      val e = assertFailsWith<IllegalArgumentException> { Name("12345") }

      assertContains( e.message?:"", NameUtils.msg.LAST_NAMES)
      assertContains( e.message?:"", NameUtils.msg.NAMES)
   }



   @Test
   fun partsWithoutComma() {
      val parts = FullName.from(NAMES)
      assertEquals(NAMES, parts.names)
      assertNull(parts.lastNames)
   }

   @Test
   fun nameInterface() {
      val n = Name(LEGAL_NAME)
      assertEquals(NAMES, n.names)
      assertEquals(LAST_NAMES, n.lastNames)
   }

   @Test
   fun get() {
      val fullName = Name(LEGAL_NAME)
      assertEquals("Sebastián", fullName.parts[0])
      assertEquals("Barrasa", fullName.parts[2])
   }

   @Test
   fun size() {
      val n = Name(LEGAL_NAME)
      assertEquals(4, n.parts.count)
   }

   @Test
   fun fullNameFormat() {
      val n = Name(LEGAL_NAME)
      assertEquals("$NAMES $LAST_NAMES", n.fullNameFormat())
   }

   @Test
   fun toStringTest() {
      val n = Name(LEGAL_NAME)
      assertEquals(LEGAL_NAME, n.toString())
   }

   @Test
   fun legalNameFormat(){
      val n = Name(LEGAL_NAME)
      assertEquals(LEGAL_NAME, n.legalNameFormat())
   }
   @Test
   fun plus(){
      val fullName1 = FullName(lastNames = LAST_NAMES, names = NAMES)
      val fullName2 = Name(LAST_NAMES) + Name(NAMES)

      assertEquals(fullName1,fullName2)

   }


}
