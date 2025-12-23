package com.swelms.common.text

enum class Case(val forString: (String) -> String, val forChar: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() });

   operator fun not() = when(this) { UPPER -> LOWER; LOWER -> UPPER }
}