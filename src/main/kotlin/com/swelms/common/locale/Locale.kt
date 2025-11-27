package com.swelms.common.locale

import com.swelms.common.text.StringSlots
import kotlin.reflect.KClass

object Locale {

   @JvmStatic
   var rootPackage: String = "locale"

   @JvmStatic
   var keyOnFail = true

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


   var currentLangConfig: AbstractLangConfig? = null

   var currentRegionalConfig: AbstractRegionalConfig? = null


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
   @JvmOverloads
   fun text(k: Class<*> = Object::class.java, key: String, keyOnFail: Boolean  = Locale.keyOnFail) = text(k.kotlin, key, keyOnFail)

   fun text(k: KClass<*> = Any::class, key: String, keyOnFail: Boolean  = Locale.keyOnFail): String {
      val map = currentLangConfig?.getTexts(k)
      val value = if(map!=null) map[key] else null
      if(value != null) return value
      if(k != Any::class) return text(Any::class, key, keyOnFail)
      if(keyOnFail) return key
      throw LocaleException(text(Locale::class, "NO_TEXT_FOUND", true)(key))
   }

}


fun Any.localeText(key: String) = Locale.text(this::class, key)

operator fun String.invoke(vararg values: Any): String = StringSlots(this).replace(values = values)

fun Locale.printAll(){
   Locale.currentLangConfig?.classTextsMap?.forEach { (clazz, map) ->
      println(clazz)
      map.forEach { (key, text) ->
         println("   $key = $text")
      }

   }
}

