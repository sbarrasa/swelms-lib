package com.sbarrasa.domain.cbu

import com.sbarrasa.domain.LegalIdException
import kotlin.test.*

class CBUTest {

   @Test
   fun validCBU() {
      val cbu = CBU("0110627130062701458101")
      assertEquals("011", cbu.bankCode)
      assertEquals("0627", cbu.branchCode)
      assertEquals("13006270145810", cbu.accountNumber)
   }

   @Test
   fun invalidLength() {
      val e = assertFailsWith<LegalIdException> { CBU("011062713006270145810") }
      assertContains(e.message ?: "", CBU.msg.INVALID_LENGTH)
   }

   @Test
   fun nonDigitCharacters() {
      val e = assertFailsWith<LegalIdException> { CBU("0110627A30062701458101") }
      assertContains(e.message ?: "", CBU.msg.DIGITS)
   }

   @Test
   fun invalidEntityBranchDigit() {
      // Modifica el dígito verificador de entidad/sucursal
      val cbuString = "0110627131062701458101"
      assertFailsWith<LegalIdException> { CBU(cbuString) }
   }

   @Test
   fun invalidAccountDigit() {
      // Modifica el dígito verificador de cuenta
      val cbuString = "0110627130062701458102"
      assertFailsWith<LegalIdException> { CBU(cbuString) }
   }

   @Test
   fun toStringTest() {
      val cbu = CBU("0110627130062701458101")
      assertEquals("0110627130062701458101", "$cbu")
   }

   @Test
   fun branchCheckDigitOk() {
      val cbu = CBU("2850590940090418135201")
      assertEquals("9", cbu.branchCheckDigit)
   }

   @Test
   fun accountCheckDigitOk() {
      val cbu = CBU("0110001300000000000000")
      assertEquals("0", cbu.accountCheckDigit)
   }
}
