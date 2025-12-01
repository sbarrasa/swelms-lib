package com.swelms.domain.person.name

import com.swelms.common.locale.localeText


typealias FullNameFormatter = ((FullName) -> String)

data class FullName(val lastNames: NamePart, val givenNames: NamePart): Names {
   var formatter: FullNameFormatter = Formatter.legalOrder

   constructor(fullNameText: String): this(
      split(fullNameText)[0],
      split(fullNameText)[1]
   )

   constructor(lastNames: String, givenNames: String): this(
      NamePart(lastNames),
      NamePart(givenNames)
   )

   fun format(customFormatter: FullNameFormatter) = customFormatter(this)

   override val text get() = this.formatter(this)

   override val list get() = givenNames.list + lastNames.list

   object Formatter {
      val legalOrder: FullNameFormatter = {"${it.lastNames}, ${it.givenNames}"}
      val fullOrder: FullNameFormatter = {"${it.givenNames} ${it.lastNames}"}
      val first_lasts: FullNameFormatter = {"${it.givenNames[0]} ${it.lastNames}"}
   }

   companion object {

      private fun split(fullNameText: String): List<String> {
         val parts = fullNameText.split(",")
         require(parts.size == 2) {"${localeText("INVALID_FORMAT")}: $fullNameText"}
         return parts.map { it.trim() }
      }
   }
}
