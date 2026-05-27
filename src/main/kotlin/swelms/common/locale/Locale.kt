package swelms.common.locale

import swelms.common.reflection.*
import swelms.common.text.replaceSlots


sealed class Locale {

   var curLangId: String? = null
      set(value) {
         if(value != null)
            langsMap[value]?: throw LocaleException(text(qName, "LANG_NOT_FOUND").replaceSlots(value))
         field = value
      }

   var curRegionalId: String? = null
      set(value) {
         if(value != null)
            regionalsMap[value] ?: throw LocaleException(text(qName, "REGIONAL_NOT_FOUND").replaceSlots(value))
         field = value
      }


   val curLang get() =  langsMap[curLangId]

   val curRegional get() =  regionalsMap[curRegionalId]


   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(qName, "NO_VALUE_FOUND").replaceSlots(key))
   }

   @Suppress("UNCHECKED_CAST")
   fun <T> valueOrNull(key: String): T? =
      curRegional?.valueMap[key]?.let { it as? T }


    fun textOrNull(module: String= DEFAULTS, key: String): String? =
       curLang
          ?.moduleTextMap[module]?.get(key)


   fun text(module: String = DEFAULTS, key: String): String =
      textOrNull(module, key)
         ?: if(module == DEFAULTS)
               key
            else
               text(DEFAULTS, key)


   companion object: Locale() {
      const val DEFAULTS = "defaults"

      val langsMap: MutableMap<String, Lang> = mutableMapOf()
      val regionalsMap: MutableMap<String, Regional> = mutableMapOf()

      @JvmStatic
      fun register(vararg cfgs: LocaleComponent) {
         cfgs.forEach { cfg ->
            when (cfg) {
               is Lang -> langsMap[cfg.locale_id] = cfg
               is Regional -> regionalsMap[cfg.locale_id] = cfg
            }
         }
      }

      @JvmStatic
      fun unregister(cfg: LocaleComponent) {
         when (cfg) {
            is Lang -> langsMap.remove(cfg.locale_id)
            is Regional -> regionalsMap.remove(cfg.locale_id)
         }
      }

   }


}

fun Any.localeText(key: String) = Locale.text(qName, key)
