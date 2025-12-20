package com.swelms.domain.id.card

import com.swelms.common.locale.Locale
import com.swelms.common.locale.localeText
import com.swelms.common.locale.replaceSlots
import com.swelms.common.reflection.qName
import com.swelms.domain.validator.DigitsValidator
import com.swelms.common.validator.ValidatorException
import com.swelms.domain.validator.LuhnValidator
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CardNumber(val value: String) {
   init {
      validateLength()
      validateDigits()
      validateCheckDigit()
   }

   val brand: CardBrand? get() = CardBrand.of(this)

   private fun validateLength() {
      if (value.length !in BinTable.lengthRange())
         throw ValidatorException(localeText("INVALID_LENGTH").replaceSlots(LOCALE_CLASS_NAME))
   }

   private fun validateDigits() {
      DigitsValidator(localeText("ONLY_DIGITS").replaceSlots(LOCALE_CLASS_NAME)).validate(value)
   }

   private fun validateCheckDigit() {
      LuhnValidator(LOCALE_CLASS_NAME).validate(value)
   }

   companion object{
      val LOCALE_CLASS_NAME = Locale.text(CardNumber::class.qName, "CARD_NUMBER")
      fun from(cardNumber: String) = CardNumber(cardNumber.filter { it.isDigit() })
   }
   override fun toString(): String = value
}

