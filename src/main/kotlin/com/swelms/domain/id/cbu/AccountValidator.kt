package com.swelms.domain.id.cbu

import com.swelms.common.locale.Locale
import com.swelms.domain.validator.CheckDigitValidator


object AccountValidator : CheckDigitValidator(Locale.text(CBU::class, "ACCOUNT")) {
   private val weights = listOf(3, 9, 7, 1, 3, 9, 7, 1, 3, 9, 7, 1, 3)

   override fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return (10 - sum % 10) % 10
   }
}