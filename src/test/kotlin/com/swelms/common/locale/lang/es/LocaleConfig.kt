package com.swelms.common.locale.lang.es

import com.swelms.common.locale.AbstractLangConfig

object LocaleConfig: AbstractLangConfig() {
   override fun register() {
      IntRange::class.register {
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      }
      Any::class.register {
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "Aún no está implementado"
      }

   }

}