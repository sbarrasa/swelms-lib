package com.swelms.common.text

enum class Case(val byString: (String) -> String, val byChar: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() });

   operator fun not() = when(this) { UPPER -> LOWER; LOWER -> UPPER }
}