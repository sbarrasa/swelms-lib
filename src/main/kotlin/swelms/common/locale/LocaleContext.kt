package swelms.common.locale

import swelms.common.reflection.*
import swelms.common.text.replaceSlots


class LocaleContext {

   var langId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.langsMap[value]?: throw LocaleException(text(qName, "LANG_NOT_FOUND").replaceSlots(value))
         field = value
      }

   var regionalId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.regionalsMap[value] ?: throw LocaleException(text(qName, "REGIONAL_NOT_FOUND").replaceSlots(value))
         field = value
      }


   val lang get() = LocaleRegistry.langsMap[langId]

   val regional get() = LocaleRegistry.regionalsMap[regionalId]


   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(qName, "NO_VALUE_FOUND").replaceSlots(key))
   }

   @Suppress("UNCHECKED_CAST")
   fun <T> valueOrNull(key: String): T? =
      regional?.valueMap[key]?.let { it as? T }


    fun textOrNull(module: String = Lang.DEFAULTS, key: String): String? =
       lang
          ?.moduleTextMap[module]?.get(key)


   fun text(module: String = Lang.DEFAULTS, key: String): String =
      textOrNull(module, key)
         ?: if(module == Lang.DEFAULTS)
               key
            else
               text(Lang.DEFAULTS, key)


   companion object {
      val default = LocaleContext()
   }

}

fun Any.localeText(key: String) = LocaleContext.default.text(qName, key)
