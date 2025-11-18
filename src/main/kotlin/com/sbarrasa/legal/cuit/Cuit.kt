package com.sbarrasa.legal.cuit

import com.sbarrasa.legal.CheckDigitValidator
import com.sbarrasa.legal.LegalException
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {

   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val check: String get() = value.substring(10, 11)

   val legalEntity: LegalEntity? get() = CuitEntityCodes[entityCode]?.legalEntity

   init {
      validateLength()
      validateDigits()
      validateEntityCode()
      validateCheckDigit()
   }

   private fun validateLength() {
      if (value.length != SIZE) throw LegalException(msg.LENGTH)
   }

   private fun validateDigits() {
      if (!value.all { it.isDigit() }) throw LegalException(msg.DIGITS)
   }

   private fun validateEntityCode() {
      if (!CuitEntityCodes.contains(entityCode)) throw LegalException(msg.ENTITY_CODE)
   }

   private fun validateCheckDigit() {
      val digits = value.map { it.digitToInt() }
      val vdInt = check.toInt()
      checkDigitValidator.validate(digits, vdInt)
   }

   object msg {
      var LENGTH = "CUIT debe tener $SIZE dígitos numéricos"
      var DIGITS = "CUIT solo puede contener números"
      var ENTITY_CODE = "Código de entidad inválido"
   }

   companion object {
      var SIZE = 11

      var checkDigitValidator = CheckDigitValidator(
         name = "CUIT",
         weights = listOf(5, 4, 3, 2, 7, 6, 5, 4, 3, 2),
         computeFinal = { sum ->
            when (val mod = sum % 11) {
               0 -> 0
               1 -> 9
               else -> 11 - mod
            }
         }
      )
   }

   override fun toString(): String = value
}