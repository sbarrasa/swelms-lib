package com.sbarrasa.domain.cuit

import com.sbarrasa.common.locale.Locale
import com.sbarrasa.domain.validator.ValidatorException
import com.sbarrasa.domain.validator.DigitsValidator
import com.sbarrasa.domain.validator.LengthValidator
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {

   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val check: Char get() = value.substring(10, 11)[0]

   val entityType: EntityType? get() = CuitEntityCodes[entityCode]?.entityType

   init {
      validateLength()
      validateDigits()
      validateEntityCode()
      validateCheckDigit()
   }

   private fun validateLength() {
      LengthValidator(texts["INVALID_LENGTH, SIZE"], SIZE).validate(value)
   }

   private fun validateDigits() {
      DigitsValidator(texts["ONLY_DIGITS"]).validate(value)
   }

   private fun validateEntityCode() {
      if (!CuitEntityCodes.contains(entityCode)) throw ValidatorException(texts["INVALID_ENTITY_CODE"])
   }

   private fun validateCheckDigit() {
      CuitCheckDigitValidator.validate(value)
   }

   companion object {
      const val SIZE = 11
      val texts get() = Locale.texts(Cuit::class)
   }

   fun formated() = "$entityCode-$document-$check"
   override fun toString(): String = value

   enum class EntityType(val description: String) {
      PERSON(texts["PERSON_DESCRIPTION"]),
      COMPANY(texts["COMPANY_DESCRIPTION"]);
   }


}