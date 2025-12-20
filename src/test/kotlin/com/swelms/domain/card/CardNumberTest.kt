package com.swelms.domain.card

import com.swelms.common.locale.localeText
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.card.CardNumber
import com.swelms.common.validator.ValidatorException
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class CardNumberTest {

   @Test
   fun brandMaestro() {
      val cn = CardNumber.from("5010410012 04257 014")
      assertEquals(CardBrand.MAESTRO, cn.brand)
   }

   @Test
   fun brandMasterCard() {
      val cn = CardNumber.from("5366 5000 0778 0600")
      assertEquals(CardBrand.MC, cn.brand)
   }

   @Test
   fun brandMasterDebito() {
      val cn = CardNumber.from("5273 4135 9148 2652")
      assertEquals(CardBrand.MC, cn.brand)
   }

   @Test
   fun brandVISA() {
      val cn = CardNumber.from("4338 2600 0327 3096")
      assertEquals(CardBrand.VISA, cn.brand)
   }

   @Test
   fun invalidLength() {
      val e = assertFailsWith<ValidatorException> { CardNumber("123") }
      assertContains( e.message ?: "", CardNumber.localeText("INVALID_LENGTH"))
   }

   @Test
   fun invalidDigit() {
      assertFailsWith<ValidatorException> { CardNumber("41111111111111A1") }
   }

   @Test
   fun invalidCheckDigit() {
      assertFailsWith<ValidatorException> { CardNumber("4111111111111112") }
   }

   @Test
   fun unknownBin() {
      val cn = CardNumber("7777777777777771")
      assertNull(cn.brand)
   }


}