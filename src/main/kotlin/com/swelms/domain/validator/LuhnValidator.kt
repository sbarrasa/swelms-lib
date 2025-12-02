package com.swelms.domain.validator

class LuhnValidator(message: String) : CheckDigitValidator(message) {
   override fun compute(digits: List<Int>): Int {
      var sum = 0
      val size = digits.size
      for (i in size - 1 downTo 0) {
         var d = digits[i]
         if ((size - i) % 2 == 1) {
            d *= 2
            if (d > 9) d -= 9
         }
         sum += d
      }
      return (10 - sum % 10) % 10
   }

}