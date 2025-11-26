package com.swelms.common.locale.lang.es

import com.swelms.common.locale.AbstractLangConfig

object LocaleConfig: AbstractLangConfig() {
   override fun register() {
      Any::class.register {
         it["INIT"] = "Inicio"
         it["END"] = "Fin"
      }
   }

}