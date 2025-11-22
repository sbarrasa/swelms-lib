package com.sbarrasa.domain.validator

import com.sbarrasa.common.locale.Locale

abstract class CheckDigitValidator(val msg: String?=null) {

   abstract fun compute(digits: List<Int>): Int

   fun compute(digits: String): Int {
      return compute(digits.map { it.digitToInt() })
   }
   
   fun splitDigits(fullNumber: String): Pair<List<Int>, Int> {
      val digits = fullNumber.dropLast(1).map { it.digitToInt() }
      val check = fullNumber.last().digitToInt()
      return digits to check
   }

   fun validate(fullNumber: String) {
      val (digits, vd) = splitDigits(fullNumber)
      validate(digits, vd)
   }

   fun validate(digits: List<Int>, vd: Int) {
      val expected = compute(digits)
      if (expected != vd) throw ValidatorException("${texts["INVALID_CHECK_DIGIT"]}: $msg")
   }

   companion object {
      val texts = Locale.texts(CheckDigitValidator::class)
   }

}