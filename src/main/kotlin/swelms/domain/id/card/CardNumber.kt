package swelms.domain.id.card

import swelms.common.locale.*
import swelms.common.text.replaceSlots
import swelms.domain.validator.*
import kotlinx.serialization.Serializable
import swelms.common.validator.ValidatorException
import swelms.domain.id.componentName

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
      private val LOCALE_CLASS_NAME = LocaleContext.current.text(componentName, "CARD_NUMBER")
      fun from(cardNumber: String) = CardNumber(cardNumber.filter { it.isDigit() })
   }
   override fun toString(): String = value
}
