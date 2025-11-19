package com.sbarrasa.domain.cuit

import com.sbarrasa.domain.validator.CheckDigitValidator
import kotlin.test.*
import com.sbarrasa.domain.LegalIdException


class CuitTest {

   @Test
   fun validCuit() {
      val cuit = Cuit("20240614708")
      assertEquals("20", cuit.entityCode)
      assertEquals("24061470", cuit.document)
      assertEquals('8', cuit.check)
   }

   @Test
   fun invalidLength() {
      val e = assertFailsWith<LegalIdException> { Cuit("2032964233") }
      assertContains(e.message ?: "", Cuit.msg.INVALID_LENGTH)
   }

   @Test
   fun nonDigitCharacters() {
      val e = assertFailsWith<LegalIdException> { Cuit("20329642A30") }
      assertContains(e.message ?: "", Cuit.msg.DIGITS)
   }

   @Test
   fun invalidEntityCode() {
      val e = assertFailsWith<LegalIdException> { Cuit("99329642330") }
      assertContains(e.message ?: "", Cuit.msg.INVALID_ENTITY_CODE)
   }

   @Test
   fun invalidCheckDigit() {
      val e = assertFailsWith<LegalIdException> { Cuit("20329642331") }
      assertContains(e.message ?: "", CheckDigitValidator.msg.INVALID_CHECK_DIGIT)
   }

   @Test
   fun validEntityTypeProperty() {
      val cuit = Cuit("20329642330")
      assertNotNull(cuit.entityType)
   }

   @Test
   fun toStringTest() {
      val cuit = Cuit("20240614708")
      assertEquals("20240614708", "$cuit")
   }

   @Test
   fun formated() {
      val cuit = Cuit("20240614708")
      assertEquals("20-24061470-8", cuit.formated())
   }

}
