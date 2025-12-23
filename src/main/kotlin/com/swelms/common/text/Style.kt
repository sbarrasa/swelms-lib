package com.swelms.common.text


enum class Case(val stringCase: (String) -> String, val charCase: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() })
}

open class Style(
   val splitChar: Char = ' ',
   val joinChar: Char? = ' ',
   val capital: Case? = null,
   val capitalFirst: Case? = null,
   val words: Case? = null,
) {

   object UpperCase : Style(words = Case.UPPER)
   object LowerCase : Style(words = Case.LOWER)
   object Title : Style(capital = Case.UPPER, joinChar = ' ')
   object Pascal : Style(capital = Case.UPPER, capitalFirst = Case.UPPER, joinChar = null)
   object Camel : Style(capital = Case.UPPER, capitalFirst = Case.LOWER, joinChar = null)
   object Snake : Style(joinChar = '_')
   object Kebab : Style(joinChar = '-')
   object Dot : Style(joinChar = '.')


   fun transform(text: String): String {
      val parts = text.split(splitChar).toMutableList()

      words?.let {
         parts.forEachIndexed { i, part -> parts[i] = words.stringCase(part) }
      }

      capital?.let {
         parts.forEachIndexed { i, part -> parts[i] = part.replaceFirstChar(capital.charCase) }
      }

      capitalFirst?.let {
         if (parts.isNotEmpty())
            parts[0] = parts[0].replaceFirstChar(capitalFirst.charCase)
      }

      return parts.joinToString(joinChar?.toString() ?: "")
   }


}

fun String.toStyle(style: Style): String = style.transform(this)
