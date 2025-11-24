package com.sbarrasa.common.locale

import com.sbarrasa.common.collections.FallbackStringMap
import kotlin.reflect.KClass

object Locale {
   var rootPackage: String = "locale"

   var lang: String? = null
      set(value) {
         field = value
         currentLangConfig = value?.let { loadModule(fullNameClass("lang", it)) }
      }


   private var currentLangConfig: AbstractLangConfig? = null

   private fun loadModule(fullNameClass: String): AbstractLangConfig {
      val localeConfig =  Class.forName(fullNameClass).kotlin.objectInstance as AbstractLangConfig
      localeConfig.register()
      return localeConfig
   }

   private fun fullNameClass(groupPackage: String, localePackage: String) =
      "$rootPackage.$groupPackage.$localePackage.LocaleConfig"

   fun text(k: KClass<*>): FallbackStringMap =
      currentLangConfig?.textsByClass?.get(k)?.let { FallbackStringMap(it) }
         ?: FallbackStringMap(emptyMap())


}

val Any.localeText: FallbackStringMap
   get() = Locale.text(this::class)
