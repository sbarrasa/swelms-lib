package com.swelms.domain.id.card

import com.swelms.common.locale.localeText
import com.swelms.domain.validator.DigitsValidator
import com.swelms.domain.validator.ValidatorException
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
      if (value.length !in BinTable.lengthRange()) throw ValidatorException(localeText("INVALID_LENGTH"))
   }

   private fun validateDigits() {
      DigitsValidator(localeText("ONLY_DIGITS")).validate(value)
   }

   private fun validateCheckDigit() {
      LuhnValidator(localeText("CARD_NUMBER")).validate(value)
   }

  

   companion object{
      fun from(cardNumber: String) = CardNumber(cardNumber.filter { it.isDigit() })
   }
   override fun toString(): String = value
}

