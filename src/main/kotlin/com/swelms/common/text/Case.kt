package com.swelms.common.text

enum class Case(val applyToString: (String) -> String, val applyToChar: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() });

   operator fun not() = when(this) {
      UPPER -> LOWER
      LOWER -> UPPER
   }
}