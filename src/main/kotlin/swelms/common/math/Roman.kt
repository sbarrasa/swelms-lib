package swelms.common.math

import swelms.common.collections.biMapOf
import swelms.common.locale.locale

val romanSymbols = biMapOf(
   1000 to 'M',
   500 to 'D',
   100 to 'C',
   50 to 'L',
   10 to 'X',
   5 to 'V',
   1 to 'I'
)

fun arabicToRoman(number: Int): String {
   require(number in 1..3999) {
      "arabic-number-out-of-range".locale
   }

   var remaining = number
   val result = StringBuilder()

   for ((value, symbol) in romanSymbols) {
      while (remaining >= value) {
         result.append(symbol)
         remaining -= value
      }

      val subtractiveValue = when (value) {
         1000, 100, 10 -> value - value / 10
         500, 50, 5 -> value - value / 5
         else -> 0
      }

      if (subtractiveValue in 1..remaining) {
         val precedingValue = value - subtractiveValue

         result.append(romanSymbols[precedingValue])
         result.append(symbol)
         remaining -= subtractiveValue
      }
   }

   return result.toString()
}

fun romanToArabic(roman: String): Int {
   val numeral = roman.uppercase()
   var result = 0

   for (i in numeral.indices) {
      val current = romanSymbols.getKey(numeral[i])
         ?: throw IllegalArgumentException("invalid-roman-symbol".locale)

      val next = if (i + 1 < numeral.length) {
         romanSymbols.getKey(numeral[i + 1])
            ?: throw IllegalArgumentException("invalid-roman-symbol".locale)
      } else {
         0
      }

      result += if (current < next) -current else current
   }

   require(
      result in 1..3999 &&
            arabicToRoman(result) == numeral
   ) {
      "invalid-roman-numeral".locale
   }

   return result
}