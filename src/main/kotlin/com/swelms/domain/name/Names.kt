package com.swelms.domain.name

import com.swelms.common.locale.localeText

interface Names  {
   val text: String
   val list: List<String> get() = split(text)
   val initials get() = list.map { it.first().uppercase() }
   operator fun get(index: Int) = list[index]
   val count: Int get() = list.size



   companion object {
      fun split(names: String): List<String> = names.trim().split(Regex("\\s+"))

      val validChars =  Regex("[^\\p{L}' ]")

      fun clean(text: String): String {
         return text.replace(validChars, "")
            .trim()
            .replace(Regex("\\s+"), " ")
      }

      fun validate(text: String){
         require(isValid(text)) { localeText("INVALID_FORMAT") }
      }

      fun isValid(text: String): Boolean {
         return text == clean(text)
      }

   }

}