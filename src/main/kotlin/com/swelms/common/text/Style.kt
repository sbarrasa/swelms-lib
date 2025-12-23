package com.swelms.common.text



data class Style(
   val splitChar: Char = ' ',
   val joinChar: Char? = ' ',
   val capital: Case? = null,
   val capitalFirst: Case? = null,
   val words: Case? = null,
) {
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

   companion object {
      @JvmField val UPPERCASE = Style(words = Case.UPPER)
      @JvmField val LOWERCASE = Style(words = Case.LOWER)
      @JvmField val TITLE = Style(capital = Case.UPPER, words = Case.LOWER)
      @JvmField val PASCAL = Style(words = Case.LOWER, capitalFirst = Case.UPPER, joinChar = null, capital = Case.UPPER)
      @JvmField val CAMEL = Style(words = Case.LOWER, capitalFirst = Case.LOWER, joinChar = null, capital = Case.UPPER)
      @JvmField val SNAKE = Style(joinChar = '_')
      @JvmField val KEBAB = Style(joinChar = '-')
      @JvmField val DOT = Style(joinChar = '.')
      @JvmField val windowsPath = Style(joinChar = '\\')
      @JvmField val unixPath = Style(joinChar = '/')

   }
   infix fun from(style: Style) = copy(splitChar = style.joinChar?:' ')

   operator fun plus(other: Style) = copy(
      splitChar = if(splitChar == ' ') other.splitChar else splitChar,
      joinChar = this.joinChar ?: other.joinChar,
      capital = this.capital ?: other.capital,
      capitalFirst = this.capitalFirst ?: other.capitalFirst,
      words = this.words ?: other.words
   )


   operator fun not() = copy(
      capital = capital?.not(),
      capitalFirst = capitalFirst?.not(),
      words = words?.not()
   )

}

enum class Case(val stringCase: (String) -> String, val charCase: (Char) -> Char) {
   UPPER({ it.uppercase() }, { it.uppercaseChar() }),
   LOWER({ it.lowercase() }, { it.lowercaseChar() });

   operator fun not() = when(this) { UPPER -> LOWER; LOWER -> UPPER }
}

fun String.asStyle(style: Style): String = style.transform(this)
