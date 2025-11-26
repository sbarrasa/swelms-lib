package com.swelms.domain.id.cuit

import com.swelms.common.locale.Locale
import com.swelms.domain.validator.CheckDigitValidator


object CuitCheckDigitValidator : CheckDigitValidator(Locale.text(Cuit::class,"CUIT_CUIL")) {
   private val weights = listOf(5, 4, 3, 2, 7, 6, 5, 4, 3, 2)

   override fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return when (val mod = sum % 11) {
         0 -> 0
         1 -> 9
         else -> 11 - mod
      }
   }
}
