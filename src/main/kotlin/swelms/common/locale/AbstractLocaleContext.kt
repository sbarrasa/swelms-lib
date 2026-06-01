package swelms.common.locale

abstract class AbstractLocaleContext {

   abstract var langId: String?

   abstract var regionalId: String?

   val lang get() = LocaleRegistry.langMap[langId]

   val regional get() = LocaleRegistry.regionalMap[regionalId]


   @Suppress("UNCHECKED_CAST")
   fun <T> value(key: String): T? = regional?.valueMap[key]?.let { it as? T }

   fun textOrNull(key: String): String? = lang?.textMap[key]

   fun text(key: String): String = textOrNull(key) ?: key

}

typealias ContextProvider = () -> AbstractLocaleContext

