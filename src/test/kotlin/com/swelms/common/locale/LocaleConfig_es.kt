package com.swelms.common.locale

object LocaleConfig_es: AbstractLangConfig() {
   override val locale_id = "es"

   override fun onLoad() {
      defaults {
         it["GENERAL"] = "Este es un mensaje general"
      }

      forClass<Any> {
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "Aún no está implementado"
      }

      forClass<IntRange> {
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      }
   }

}