package com.sbarrasa.common.locale

import com.sbarrasa.common.collections.FallbackStringMap
import com.sbarrasa.common.collections.StringMap
import kotlin.reflect.KClass

object Locale {
   private val textsByClass = mutableMapOf<KClass<*>, StringMap>()

   var rootPackage: String = "locale"
   var lang: String? = null
   var regional: String? = null

   fun load() {
      lang?.let { loadModule("$rootPackage.lang.$it.LocaleConfig") }
      regional?.let { loadModule("$rootPackage.regional.$it.LocaleConfig") }
   }

   private fun loadModule(fullNameClass: String) {
      Class.forName(fullNameClass).kotlin.objectInstance
   }


   fun register(k: KClass<*>, block: (MutableMap<String, String>) -> Unit) {
      val map = mutableMapOf<String, String>()
      block(map)
      textsByClass[k] = map
   }

   fun texts(k: KClass<*>): FallbackStringMap =
      FallbackStringMap(textsByClass[k] ?: emptyMap())
}
