package com.swelms.common.locale

import com.swelms.common.text.StringSlots
import kotlin.reflect.KClass

object Locale {

   @JvmStatic
   var throwOnMissing = false

   @JvmStatic
   var lang: String? = null
      set(value) {
         langConfigs[field]?.unload()
         if(value != null) {
            langConfigs[value]
               ?.load()
               ?:throw LocaleException(text(Locale::class, "LANG_NOT_FOUND", keyOnMissing = true).replaceSlots(value))
         }
         field = value
      }

   @JvmStatic
   var regional: String? = null
      set(value) {
         regionalConfigs[field]?.unload()
         if(value != null) {
           regionalConfigs[value]
              ?.load()
              ?: throw LocaleException(text(Locale::class, "REGIONAL_NOT_FOUND", keyOnMissing = true).replaceSlots(value))
         }
         field = value
      }

   private val langConfigs: MutableMap<String, AbstractLangConfig> = mutableMapOf()
   private val regionalConfigs: MutableMap<String, AbstractRegionalConfig> = mutableMapOf()

   @JvmStatic
   fun registerConfigs(vararg cfgs: AbstractLocaleConfig) {
      cfgs.forEach { registerConfig(it) }
   }

   @JvmStatic
   fun registerConfig(cfg: AbstractLocaleConfig) {
      when (cfg) {
         is AbstractLangConfig -> langConfigs[cfg.key] = cfg
         is AbstractRegionalConfig -> regionalConfigs[cfg.key] = cfg
      }
   }


   @JvmStatic
   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(Locale::class, "NO_VALUE_FOUND", true).replaceSlots(key))
   }

   @Suppress("UNCHECKED_CAST")
   @JvmStatic
   fun <T> valueOrNull(key: String): T? {
      val value = regionalConfigs[regional]?.values?.get(key) as? T
      if(value==null && throwOnMissing)
         throw LocaleException(text(Locale::class, "NO_VALUE_FOUND", true).replaceSlots(key))

      return value
   }

   @JvmStatic
   @JvmOverloads
   fun text(k: Class<*> = Object::class.java, key: String, keyOnMissing: Boolean = !throwOnMissing)
      = text(k.kotlin, key, keyOnMissing)

   fun text(klass: KClass<*> = Any::class, key: String, keyOnMissing: Boolean = !throwOnMissing): String {
      val map = langConfigs[lang]?.texts(klass)
      val value = if(map!=null) map[key] else null
      if(value != null) return value
      if(klass != Any::class) return text(Any::class, key, keyOnMissing)
      if(keyOnMissing) return key
      throw LocaleException(text(Locale::class, "NO_TEXT_FOUND", keyOnMissing = true).replaceSlots(key))
   }

   fun text(key: String, keyOnMissing: Boolean = !throwOnMissing)
      = text(Any::class, key, keyOnMissing)

}

fun Any.localeText(key: String) = Locale.text(this::class, key)

fun String.replaceSlots(vararg values: Any): String = StringSlots(this).replace(*values)


