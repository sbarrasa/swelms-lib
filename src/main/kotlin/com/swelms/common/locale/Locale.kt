package com.swelms.common.locale

import com.swelms.common.collections.FallbackStringMap
import com.swelms.common.text.StringSlots
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
      val clazz =  Class.forName(fullNameClass, false, this.javaClass.classLoader )
      val localeConfig = clazz.kotlin.objectInstance as AbstractLocaleConfig
      return load(localeConfig)
   }


   internal fun load(localeConfig: AbstractLocaleConfig):AbstractLocaleConfig{
      localeConfig.register()
      return localeConfig
   }

   private fun fullNameClass(groupPackage: String, localePackage: String) =
      "$rootPackage.$groupPackage.$localePackage.LocaleConfig"

   @Suppress("UNCHECKED_CAST")
   @JvmStatic
   fun <T> valueOf(key: String): T? =
      currentRegionalConfig?.values?.get(key) as T?

   @JvmStatic
   fun textsByClass(k: Class<*>): FallbackStringMap = textsByClass(k.kotlin)

   fun textsByClass(k: KClass<*>): FallbackStringMap {
      val key = cleanKey(k)
      val value = currentLangConfig?.textsByClass?.get(key)
      if(value == null) {
         if (k != Any::class) return textsByClass(Any::class)
         return FallbackStringMap(emptyMap())
      }

      return FallbackStringMap(value)
   }

   internal fun cleanKey(k: KClass<*>): String {
      val q = k.qualifiedName ?: k.toString()
      return q.replace(".Companion", "")
   }


}

val Any.localeText: FallbackStringMap
   get() = Locale.textsByClass(this::class)

val <T: Any> KClass<T>.localeText: FallbackStringMap
   get() = Locale.textsByClass(this)

operator fun String.invoke(vararg values: Any): String = StringSlots(this).replace(values = values)
