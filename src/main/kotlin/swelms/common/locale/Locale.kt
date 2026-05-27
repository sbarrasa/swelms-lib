package swelms.common.locale

import swelms.common.reflection.*
import swelms.common.text.replaceSlots

object Locale {

   const val DEFAULTS = "defaults"

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
   val regionalsMap: MutableMap<String, RegionalInterface> = mutableMapOf()

   val currentLang get() =  langsMap[lang]

   val currentRegional get() =  regionalsMap[regional]


   @JvmStatic
   fun register(vararg cfgs: LocaleDataInterface) {
      cfgs.forEach { cfg ->
         when (cfg) {
            is LangInterface -> langsMap[cfg.locale_id] = cfg
            is RegionalInterface -> regionalsMap[cfg.locale_id] = cfg
         }
      }
   }

   @JvmStatic
   fun unregister(cfg: LocaleDataInterface) {
      when (cfg) {
         is LangInterface -> {
            if(lang == cfg.locale_id) lang = null
            langsMap.remove(cfg.locale_id)
         }
         is RegionalInterface -> {
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
    fun textOrNull(module: String= DEFAULTS, key: String): String? =
       currentLang
          ?.moduleTextMap[module]?.get(key)


   @JvmStatic
   fun text(module: String = DEFAULTS, key: String): String =
      textOrNull(module, key)
         ?: if(module == DEFAULTS)
               key
            else
               text(DEFAULTS, key)

}

fun Any.localeText(key: String) = Locale.text(qName, key)


