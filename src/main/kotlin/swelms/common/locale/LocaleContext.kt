package swelms.common.locale

import swelms.common.text.replaceSlots


class LocaleContext {

   var langId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.langsMap[value]?: throw LocaleException(text(componentName, "LANG_NOT_FOUND").replaceSlots(value))
         field = value
      }

   var regionalId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.regionalsMap[value] ?: throw LocaleException(text(componentName, "REGIONAL_NOT_FOUND").replaceSlots(value))
         field = value
      }


   val lang get() = LocaleRegistry.langsMap[langId]

   val regional get() = LocaleRegistry.regionalsMap[regionalId]


   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(componentName, "NO_VALUE_FOUND").replaceSlots(key))
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
      var contextProvider: LocaleContextProvider? = null
      val current = contextProvider?.current?: default
   }

}

fun Any.localeText(key: String) = LocaleContext.current.text(this::class.qualifiedName!!, key)
fun Any.localeTextOrNull(key: String) = LocaleContext.current.textOrNull(this::class.qualifiedName!!, key)
