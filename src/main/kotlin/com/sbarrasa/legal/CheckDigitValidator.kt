package com.sbarrasa.legal

class CheckDigitValidator(
   val name: String = "",
   private val weights: List<Int>,
   private val computeFinal: (Int) -> Int
) {
   fun compute(digits: List<Int>): Int {
      val sum = digits.zip(weights) { d, w -> d * w }.sum()
      return computeFinal(sum)
   }

   fun validate(digits: List<Int>, vd: Int) {
      val expected = compute(digits)
      if(expected != vd) throw LegalException("${msg.INVALID_CHECK_DIGIT} ($name)")
   }

   object msg {
      var INVALID_CHECK_DIGIT = "Dígito verificador inválido"
   }
}