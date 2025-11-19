package com.sbarrasa.dommain.person

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import com.sbarrasa.domain.person.Name
import com.sbarrasa.domain.person.NameParts
import kotlin.test.assertContains
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class LegalNameTest {
   companion object{
      private const val NAMES = "Sebastián Gabriel"
      private const val LAST_NAMES = "Barrasa Rabinovich"
      private const val LEGAL_NAME = "$LAST_NAMES, $NAMES"
   }


   @Test
   fun clean() {
      assertEquals(LEGAL_NAME,
         Name.clean(" Barrasa  *  Rabinovich, Sebastián 1234 Gabriel "))
   }

   @Test
   fun isValid() {
      assertTrue(Name.isValid(LEGAL_NAME))
   }

   @Test
   fun invalid(){
      val e = assertFailsWith<IllegalArgumentException> { Name("12345") }


      assertContains( e.message?:"", Name.msg.LAST_NAMES)
      assertContains( e.message?:"", Name.msg.NAMES)
   }

   @Test
   fun notIsValid() {
      assertFalse(Name.isValid(" Sebastián Gabriel "))
      assertFalse(Name.isValid("Barrasa,, Sebastián"))
      assertFalse(Name.isValid("Barrasa1, Sebastián"))
   }


   @Test
   fun partsWithoutComma() {
      val parts = NameParts.from(NAMES)
      assertEquals(NAMES, parts.names)
      assertNull(parts.lastNames)
   }

   @Test
   fun names() {
      val n = Name(LEGAL_NAME)
      assertEquals(NAMES, n.names)
      assertEquals(LAST_NAMES, n.lastNames)
   }

   @Test
   fun nameList() {
      val n = Name(LEGAL_NAME)
      assertEquals(listOf("Sebastián", "Gabriel"), n.nameList)
      assertEquals(listOf("Barrasa", "Rabinovich"), n.lastNameList)
   }

   @Test
   fun fullNameList() {
      val n = Name(LEGAL_NAME)
      assertEquals(listOf("Sebastián", "Gabriel", "Barrasa", "Rabinovich"),
         n.fullNameList)
   }

   @Test
   fun get() {
      val fullName = Name(LEGAL_NAME)
      assertEquals("Sebastián", fullName[0])
      assertEquals("Barrasa", fullName[2])
   }

   @Test
   fun size() {
      val n = Name(LEGAL_NAME)
      assertEquals(4, n.count)
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
      val name = Name(NAMES)
      val lastName = Name(LAST_NAMES)
      val fullName1 = lastName + name
      val fullName2 = Name(LEGAL_NAME)

      assertEquals(fullName1,fullName2)

      assertFailsWith<IllegalArgumentException> { fullName1 + name }

   }


}
