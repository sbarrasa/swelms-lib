package com.swelms.common.locale.lang.es

import com.swelms.common.locale.AbstractLangConfig

object LocaleConfig: AbstractLangConfig() {
   override fun register() {
      defaults {
         it["GENERAL"] = "Este es un mensaje general"
      }

      texts<Any> {
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "Aún no está implementado"
      }

      texts<IntRange> {
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      }
   }

}