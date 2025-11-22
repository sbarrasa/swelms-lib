package com.sbarrasa.domain.person

import com.sbarrasa.common.locale.Locale

object NameUtils {

   val validChars =  Regex("[^\\p{L}' ]")
   val texts get() = Locale.texts(NameUtils::class)

   fun clean(text: String): String {
      return text.replace(validChars, "")
         .trim()
         .replace(Regex("\\s+"), " ")
   }

   fun validate(text: String, isFullName: Boolean = false){
      if(isFullName){
         val parts = split(text)
         validate(parts[0].trim(), isFullName = false)
         validate(parts[1].trim(), isFullName = false)
      } else {
         require(isValid(text)) { texts["INVALID_FORMAT"] }
      }
   }

   fun isValid(text: String): Boolean {
      return text == clean(text)
   }

   fun split(fullNameText: String): List<String> {
      val parts = fullNameText.split(",")
      if (parts.size != 2) throw IllegalArgumentException(texts["INVALID_FORMAT"])
      return parts
   }

}