package com.swelms.domain.validator

import com.swelms.common.validator.*

abstract class CheckDigitValidator(val message: String) : Validable<String> {

   abstract fun compute(digits: List<Int>): Int

   fun compute(digits: String): Int {
      return compute(digits.map { it.digitToInt() })
   }
   
   fun splitDigits(fullNumber: String): Pair<List<Int>, Int> {
      val digits = fullNumber.dropLast(1).map { it.digitToInt() }
      val check = fullNumber.last().digitToInt()
      return digits to check
   }

   override fun validate(obj: String): String {
      val (digits, vd) = splitDigits(obj)
      validate(digits, vd)
      return obj
   }

   fun validate(digits: List<Int>, vd: Int): String {
      val expected = compute(digits)
      if (expected != vd) throw ValidatorException(message)
      return digits.joinToString("")+vd
   }

}