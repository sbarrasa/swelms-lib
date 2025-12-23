package com.swelms.common.text


enum class Case(val stringCase: (String) -> String, val charCase: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() })
}

data class Style(
   val splitChar: Char = ' ',
   val joinChar: Char? = ' ',
   val capital: Case? = null,
   val capitalFirst: Case? = null,
   val words: Case? = null,
) {

   companion object {
      @JvmField val UPPERCASE = Style(words = Case.UPPER)
      @JvmField val LOWERCASE = Style(words = Case.LOWER)
      @JvmField val TITLE = Style(capital = Case.UPPER, joinChar = ' ')
      @JvmField val PASCAL = Style(capital = Case.UPPER, capitalFirst = Case.UPPER, joinChar = null)
      @JvmField val CAMEL = Style(capital = Case.UPPER, capitalFirst = Case.LOWER, joinChar = null)
      @JvmField val SNAKE = Style(joinChar = '_')
      @JvmField val KEBAB = Style(joinChar = '-')
      @JvmField val DOT = Style(joinChar = '.')
      @JvmField val windowsPath = Style(joinChar = '\\')
      @JvmField val unixPath = Style(joinChar = '/')

   }
   infix fun from(style: Style) = copy(
      splitChar = style.joinChar?:' '

   )
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
