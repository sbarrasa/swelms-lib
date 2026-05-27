package swelms.domain.id.cbu

import swelms.common.locale.*
import swelms.domain.id.componentName
import swelms.domain.validator.CheckDigitValidator

object BranchValidator : CheckDigitValidator(LocaleContext.current.text(componentName, "BRANCH")) {
   private val weights = listOf(7, 1, 3, 9, 7, 1, 3)

   override fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return (10 - sum % 10) % 10
   }
}