package com.sbarrasa.domain.cbu

import com.sbarrasa.common.locale.Locale
import com.sbarrasa.domain.validator.DigitsValidator
import com.sbarrasa.domain.validator.LengthValidator
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CBU(val value: String) {

   val bankCode get() = value.substring(0, 3)
   val branchCode get() = value.substring(3, 7)
   val accountNumber get() = value.substring(7, 21)
   val branchCheckDigit get() = value.substring(7, 8)
   val accountCheckDigit get() = value.substring(21, 22)


   init {
      validateLength()
      validateDigits()
      validateEntityBranchDigit()
      validateAccountDigit()
   }

   private fun validateLength() {
      LengthValidator(texts["INVALID_LENGTH"], SIZE).validate(value)
   }

   private fun validateDigits() {
      DigitsValidator(texts["ONLY_DIGITS"]).validate(value)
   }

   private fun validateEntityBranchDigit() {
      val digits = value.substring(0, 7).map { it.digitToInt() }
      val vd = value[7].digitToInt()
      BranchValidator.validate(digits, vd)
   }

   private fun validateAccountDigit() {
      val digits = value.substring(8, 21).map { it.digitToInt() }
      val vd = value[21].digitToInt()
      AccountValidator.validate(digits, vd)
   }

   companion object {
      var SIZE = 22
      val texts get() = Locale.texts(CBU::class)

   }

   override fun toString(): String = value
}