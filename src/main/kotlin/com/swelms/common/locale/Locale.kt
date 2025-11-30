package com.swelms.common.locale

import com.swelms.common.text.StringSlots
import com.swelms.common.reflection.*

object Locale {

   var defaultOnMissing = true
   var keyOnMissing = true
   var DEFAULT = "default"

   @JvmStatic
   var lang: String? = null
      set(value) {
         if(value != null)
            langsMap[value]?: throw LocaleException(text(qName, "LANG_NOT_FOUND").replaceSlots(value))
         field = value
      }

   @JvmStatic
   var regional: String? = null
      set(value) {
         if(value != null)
            regionalsMap[value] ?: throw LocaleException(text(qName, "REGIONAL_NOT_FOUND").replaceSlots(value))
         field = value
      }

   val langsMap: MutableMap<String, AbstractLangConfig> = mutableMapOf()
   val regionalsMap: MutableMap<String, AbstractRegionalConfig> = mutableMapOf()

   val currentLang get() =  langsMap[lang]

   val currentRegional get() =  regionalsMap[regional]


   @JvmStatic
   fun registerConfigs(vararg cfgs: AbstractLocaleConfig) {
      cfgs.forEach { registerConfig(it) }
   }

   @JvmStatic
   fun registerConfig(cfg: AbstractLocaleConfig) {
      when (cfg) {
         is AbstractLangConfig -> langsMap[cfg.locale_id] = cfg
         is AbstractRegionalConfig -> regionalsMap[cfg.locale_id] = cfg
      }
   }

   @JvmStatic
   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(qName, "NO_VALUE_FOUND").replaceSlots(key))
   }

   @Suppress("UNCHECKED_CAST")
   @JvmStatic
   fun <T> valueOrNull(key: String): T? =
      currentRegional?.valueMap[key]?.let { it as? T }


   @JvmStatic
   fun textOrNull(module: String? = null, key: String): String? {
      val text = currentLang?.textsByModule[module]?.get(key)
      if(text == null && defaultOnMissing && module != DEFAULT) return textOrNull(DEFAULT, key)
      return text
   }


   @JvmStatic
   fun text(module: String? = null,  key: String): String {
      val text = textOrNull(module, key)
      if(text == null) {
         if (keyOnMissing || module == qName) return key
         else throw LocaleException(text(qName, "NO_TEXT_FOUND").replaceSlots(key))
      }
      return text
   }


}

fun Any.localeText(key: String) = Locale.text(qName, key)

fun String.replaceSlots(vararg values: Any): String = StringSlots(this).replace(*values)


