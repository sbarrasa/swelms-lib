package com.swelms.common.locale

import com.swelms.common.collections.FallbackStringMap
import kotlin.reflect.KClass

object Locale {

   @JvmStatic
   var rootPackage: String = "locale"

   @JvmStatic
   var lang: String? = null
      set(value) {
         field = value
         currentLangConfig = value?.let { load(fullNameClass("lang", it)) as AbstractLangConfig }
      }

   @JvmStatic
   var regional: String? = null
      set(value) {
         field = value
         currentRegionalConfig = value?.let { load(fullNameClass("regional", it)) as AbstractRegionalConfig }
      }


   internal var currentLangConfig: AbstractLangConfig? = null
   internal var currentRegionalConfig: AbstractRegionalConfig? = null

   private fun load(fullNameClass: String):AbstractLocaleConfig{
      val localeConfig =  Class.forName(fullNameClass).kotlin.objectInstance as AbstractLocaleConfig
      return load(localeConfig)
   }

   internal fun load(localeConfig: AbstractLocaleConfig):AbstractLocaleConfig{
      localeConfig.register()
      return localeConfig
   }

   private fun fullNameClass(groupPackage: String, localePackage: String) =
      "$rootPackage.$groupPackage.$localePackage.LocaleConfig"

   @JvmStatic
   fun text(k: Class<*>): FallbackStringMap = text(k.kotlin)

   @JvmStatic
   fun text(k: KClass<*>): FallbackStringMap {
      val key = keyFrom(k)
      val value = currentLangConfig?.textsByClass?.get(key)
      if(value == null) {
         if (k != Any::class) return text(Any::class)
         return FallbackStringMap(emptyMap())
      }

      return FallbackStringMap(value)
   }

   @JvmStatic
   fun keyFrom(k: KClass<*>): String {
      val q = k.qualifiedName ?: k.toString()
      return q.replace(".Companion", "")
   }

   @Suppress("UNCHECKED_CAST")
   @JvmStatic
   fun <T> valueOf(key: String): T? =
      currentRegionalConfig?.values?.get(key) as T?

}

val Any.localeText: FallbackStringMap
   get() = Locale.text(this::class)

val <T: Any> KClass<T>.localeText: FallbackStringMap
   get() = Locale.text(this)