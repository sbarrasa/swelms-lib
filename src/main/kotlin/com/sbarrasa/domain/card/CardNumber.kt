package com.sbarrasa.domain.card

import com.sbarrasa.common.locale.Locale
import com.sbarrasa.domain.validator.DigitsValidator
import com.sbarrasa.domain.validator.ValidatorException
import com.sbarrasa.domain.validator.LuhnValidator
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
      if (value.length !in BinTable.lengthRange()) throw ValidatorException(texts["INVALID_LENGTH"])
   }

   private fun validateDigits() {
      DigitsValidator(texts["ONLY_DIGITS"]).validate(value)
   }

   private fun validateCheckDigit() {
      LuhnValidator(texts["CARD_NUMBER"]).validate(value)
   }

  

   companion object{
      fun from(cardNumber: String) = CardNumber(cardNumber.filter { it.isDigit() })
      val texts get() = Locale.text(CardNumber::class)
   }
   override fun toString(): String = value
}

