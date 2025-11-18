package com.sbarrasa.fiscal.cbu

import com.sbarrasa.fiscal.FiscalException
import kotlin.test.*

class CBUValidatorTest {

   @Test
   fun validCBU() {
      val cbu = CBU("0110627130062701458101")
      assertEquals("011", cbu.bankCode)
      assertEquals("0627", cbu.branchCode)
      assertEquals("13006270145810", cbu.accountNumber)
   }

   @Test
   fun invalidLength() {
      val e = assertFailsWith<FiscalException> { CBU("011062713006270145810") }
      assertContains(e.message ?: "", CBU.msg.LENGTH)
   }

   @Test
   fun nonDigitCharacters() {
      val e = assertFailsWith<FiscalException> { CBU("0110627A30062701458101") }
      assertContains(e.message ?: "", CBU.msg.DIGITS)
   }

   @Test
   fun invalidEntityBranchDigit() {
      // Modifica el dígito verificador de entidad/sucursal
      val cbuString = "0110627131062701458101"
      assertFailsWith<FiscalException> { CBU(cbuString) }
   }

   @Test
   fun invalidAccountDigit() {
      // Modifica el dígito verificador de cuenta
      val cbuString = "0110627130062701458102"
      assertFailsWith<FiscalException> { CBU(cbuString) }
   }

   @Test
   fun toStringTest() {
      val cbu = CBU("0110627130062701458101")
      assertEquals("0110627130062701458101", "$cbu")
   }

   @Test
   fun branchCheckDigitOk() {
      val cbu = CBU("2850590940090418139121")
      assertEquals("0", cbu.branchCheckDigit)
   }

   @Test
   fun accountCheckDigitOk() {
      val cbu = CBU("2850590940090418139121")
      assertEquals("1", cbu.accountCheckDigit)
   }
}
