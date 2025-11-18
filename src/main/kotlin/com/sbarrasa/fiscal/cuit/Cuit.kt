package com.sbarrasa.fiscal.cuit

import com.sbarrasa.fiscal.CheckDigitValidator
import com.sbarrasa.fiscal.FiscalException
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {

   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val check: String get() = value.substring(10, 11)

   val entityType: EntityType? get() = EntityCodes[entityCode]?.entityType

   init {
      validateLength()
      validateDigits()
      validateEntityCode()
      validateCheckDigit()
   }

   private fun validateLength() {
      if (value.length != SIZE) throw FiscalException(msg.LENGTH)
   }

   private fun validateDigits() {
      if (!value.all { it.isDigit() }) throw FiscalException(msg.DIGITS)
   }

   private fun validateEntityCode() {
      if (!EntityCodes.contains(entityCode)) throw FiscalException(msg.ENTITY_CODE)
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
