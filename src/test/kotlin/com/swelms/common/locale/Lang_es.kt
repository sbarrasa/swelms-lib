package com.swelms.common.locale

import com.swelms.common.reflection.qName

object Lang_es : LangInterface {
   override val locale_id = "es"

   override val moduleTextMap = mapOf(
      Locale.DEFAULT to mutableMapOf(
         "GENERAL" to "Este es un mensaje general",
         "TEST"            to "Prueba",
         "NOT_IMPLEMENTED" to "Aún no está implementado"
      ),

      IntRange::class.qName to mutableMapOf(
         "OUT_OF_RANGE" to "El valor debe estar entre {1} y {2}"
      )
   )
}
