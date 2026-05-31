package swelms.common.locale

import swelms.common.reflection.component
import swelms.common.text.replaceSlots


sealed class LocaleContext {

   var langId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.langsMap[value]?: throw LocaleException(text(component("LANG_NOT_FOUND")).replaceSlots(value))
         field = value
      }

   var regionalId: String? = null
      set(value) {
         if(value != null)
            LocaleRegistry.regionalsMap[value] ?: throw LocaleException(text(component("REGIONAL_NOT_FOUND")).replaceSlots(value))
         field = value
      }


   val lang get() = LocaleRegistry.langsMap[langId]

   val regional get() = LocaleRegistry.regionalsMap[regionalId]


   fun <T> value(key: String): T {
      return valueOrNull(key)
         ?: throw LocaleException(text(component("NO_VALUE_FOUND")).replaceSlots(key))
   }

   @Suppress("UNCHECKED_CAST")
   fun <T> valueOrNull(key: String): T? = regional?.valueMap[key]?.let { it as? T }


   fun textOrNull(key: String): String? = lang?.textMap[key]

   fun text(key: String): String = textOrNull(key) ?: key

   companion object: LocaleContext() {
      var contextProvider: ContextProvider? = null
      val current = contextProvider?.invoke()?: LocaleContext
   }
}

typealias ContextProvider = () -> LocaleContext

