package com.swelms.common.locale

import com.swelms.common.reflection.qName

object Lang_en : LangInterface {
   override val locale_id = "en"

   override val textsByModule = mapOf(
      Locale.DEFAULT to mutableMapOf(
         "GENERAL" to "This is a general message",
         "TEST"            to "Test",
         "NOT_IMPLEMENTED" to "Not implemented yet"
      ),


      IntRange::class.qName to mutableMapOf(
         "OUT_OF_RANGE" to "Value must be between {1} and {2}"
      )
   )
}
