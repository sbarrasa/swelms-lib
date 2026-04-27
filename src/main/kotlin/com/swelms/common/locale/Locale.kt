package com.swelms.common.locale

import com.swelms.common.reflection.*
import com.swelms.common.text.replaceSlots

object Locale {

   @JvmStatic
   var defaultOnMissing = true
   @JvmStatic
   var keyOnMissing = true
   @JvmStatic
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

   val langsMap: MutableMap<String, LangInterface> = mutableMapOf()
   val regionalsMap: MutableMap<String, Regionalinterface> = mutableMapOf()

   val currentLang get() =  langsMap[lang]

   val currentRegional get() =  regionalsMap[regional]


   @JvmStatic
   fun register(vararg cfgs: LocaleInterface) {
      cfgs.forEach { cfg ->
         when (cfg) {
            is LangInterface -> langsMap[cfg.locale_id] = cfg
            is Regionalinterface -> regionalsMap[cfg.locale_id] = cfg
         }
      }
   }

   @JvmStatic
   fun unregister(cfg: LocaleInterface) {
      when (cfg) {
         is LangInterface -> {
            if(lang == cfg.locale_id) lang = null
            langsMap.remove(cfg.locale_id)
         }
         is Regionalinterface -> {
            if(regional == cfg.locale_id) regional = null
            regionalsMap.remove(cfg.locale_id)
         }
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
   fun textOrNull(module: String = DEFAULT, key: String): String? {
      val text = currentLang?.moduleTextMap[module]?.get(key)
      if(text == null && defaultOnMissing && module != DEFAULT) return textOrNull(key = key)
      return text
   }


   @JvmStatic
   fun text(module: String = DEFAULT,  key: String): String {
      val text = textOrNull(module, key)
      if(text == null) {
         if (keyOnMissing || module == qName) return key
         else throw LocaleException(text(qName, "NO_TEXT_FOUND").replaceSlots(key))
      }
      return text
   }


}

fun Any.localeText(key: String) = Locale.text(qName, key)


