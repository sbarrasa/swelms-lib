package com.sbarrasa.fiscal.cbu

import com.sbarrasa.fiscal.CheckDigitValidator
import com.sbarrasa.fiscal.FiscalException
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
      if (value.length != SIZE) throw FiscalException(msg.LENGTH)
   }

   private fun validateDigits() {
      if (!value.all { it.isDigit() }) throw FiscalException(msg.DIGITS)
   }

   private fun validateEntityBranchDigit() {
      val digits = value.substring(0, 7).map { it.digitToInt() }
      val vd = value[7].digitToInt()
      entityBranchValidator.validate(digits, vd)
   }

   private fun validateAccountDigit() {
      val digits = value.substring(8, 21).map { it.digitToInt() }
      val vd = value[21].digitToInt()
      accountValidator.validate(digits, vd)
   }

   object msg {
      var LENGTH = "CBU debe tener 22 dígitos"
      var DIGITS = "CBU solo puede contener números"
   }

   companion object {
      var SIZE = 22

      private val entityBranchValidator = CheckDigitValidator(
         name = "Entidad bancaria y sucursal",
         weights = listOf(7, 1, 3, 9, 7, 1, 3),
         computeFinal = { sum -> (10 - sum % 10) % 10 }
      )

      private val accountValidator = CheckDigitValidator(
         name = "Cuenta bancaria",
         weights = listOf(3, 9, 7, 1, 3, 9, 7, 1, 3, 9, 7, 1, 3),
         computeFinal = { sum -> (10 - sum % 10) % 10 }
      )
   }

   override fun toString(): String = value
}
