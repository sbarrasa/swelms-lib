package swelms.common.locale

import swelms.common.text.replaceSlots

abstract class LocaleContext {

   abstract var langId: String?

   abstract var regionalId: String?

   val lang get() = LocaleRegistry.langMap[langId]

   val regional get() = LocaleRegistry.regionalMap[regionalId]


   @Suppress("UNCHECKED_CAST")
   fun <T> regional(key: String): T? = regional?.valueMap[key]?.let { it as? T }

   fun textOrNull(key: String): String? = lang?.textMap[key]

   fun text(key: String): String = textOrNull(key) ?: key

}

typealias ContextProvider = () -> LocaleContext

