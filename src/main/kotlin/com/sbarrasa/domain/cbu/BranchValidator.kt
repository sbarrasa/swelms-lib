package com.sbarrasa.domain.cbu

import com.sbarrasa.common.locale.Locale
import com.sbarrasa.domain.validator.CheckDigitValidator

object BranchValidator : CheckDigitValidator(Locale.text(CBU::class)["BRANCH"]) {
   private val weights = listOf(7, 1, 3, 9, 7, 1, 3)

   override fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return (10 - sum % 10) % 10
   }
}