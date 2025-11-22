package com.sbarrasa.common.locale

object Locale {
   var rootPackage = "locale"
   var lang: String = "es"
   var config: String = "ar"

   fun load() {
      loadModule("$rootPackage.lang.$lang.LocalConfig")
      loadModule("$rootPackage.regional.$config.LocalConfig")
   }

   private fun loadModule(fullNameClass: String) {
      Class.forName(fullNameClass).kotlin.objectInstance
   }


}
