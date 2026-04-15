package com.swelms.common.text



data class Style(
   val splitChar: Char = ' ',
   val joinChar: Char? = ' ',
   val wordsCase: Case? = null,
   val firstCharCase: Case? = null,
   val firstWordCharCase: Case? = null,
) {
   fun transform(text: String): String {
      val parts = text.split(splitChar).toMutableList()

      wordsCase?.let {
         parts.forEachIndexed { i, part -> parts[i] = wordsCase.applyTo(part) }
      }

      firstWordCharCase?.let {
         parts.forEachIndexed { i, part -> parts[i] = part.replaceFirstChar(firstWordCharCase.applyToChar) }
      }

      firstCharCase?.let {
         if (parts.isNotEmpty())
            parts[0] = parts[0].replaceFirstChar(firstCharCase.applyToChar)
      }

      return parts.joinToString(joinChar?.toString() ?: "")
   }

   companion object {
      @JvmField val UPPERCASE = Style(wordsCase = Case.UPPER)
      @JvmField val LOWERCASE = Style(wordsCase = Case.LOWER)
      @JvmField val TITLE = Style(firstWordCharCase = Case.UPPER, wordsCase = Case.LOWER)
      @JvmField val PASCAL = TITLE.copy(joinChar = null)
      @JvmField val CAMEL = PASCAL.copy(firstCharCase = Case.LOWER)
      @JvmField val SNAKE = Style(joinChar = '_')
      @JvmField val KEBAB = Style(joinChar = '-')
      @JvmField val DOT = Style(joinChar = '.')
      @JvmField val windowsPath = Style(joinChar = '\\')
      @JvmField val unixPath = Style(joinChar = '/')

   }
   infix fun from(styleFrom: Style) = copy(splitChar = styleFrom.joinChar?:' ')
   infix fun to(styleTo: Style) = styleTo.copy(splitChar = joinChar?:' ')

   operator fun plus(other: Style) = copy(
      splitChar = if(splitChar == ' ') other.splitChar else splitChar,
      joinChar = this.joinChar ?: other.joinChar,
      firstWordCharCase = this.firstWordCharCase ?: other.firstWordCharCase,
      firstCharCase = this.firstCharCase ?: other.firstCharCase,
      wordsCase = this.wordsCase ?: other.wordsCase
   )


   operator fun not() = copy(
      firstWordCharCase = firstWordCharCase?.not(),
      firstCharCase = firstCharCase?.not(),
      wordsCase = wordsCase?.not()
   )

}


fun String.applyStyle(style: Style) = style.transform(this)
