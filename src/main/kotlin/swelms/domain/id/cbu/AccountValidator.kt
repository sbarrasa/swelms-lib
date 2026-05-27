package swelms.domain.id.cbu

import swelms.common.locale.*
import swelms.common.reflection.qName
import swelms.domain.validator.CheckDigitValidator


object AccountValidator : CheckDigitValidator(LocaleContext.default.text(CBU::class.qName, "ACCOUNT")) {
   private val weights = listOf(3, 9, 7, 1, 3, 9, 7, 1, 3, 9, 7, 1, 3)

   override fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return (10 - sum % 10) % 10
   }
}
