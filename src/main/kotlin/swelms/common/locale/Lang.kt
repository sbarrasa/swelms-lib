package swelms.common.locale

import kotlinx.serialization.Serializable
import swelms.common.reflection.qName

typealias LangBlock = (MutableMap<String,String>) -> Unit

@Serializable
data class Lang(override val locale_id: String,
                override val moduleTextMap: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
) : LangInterface {
   constructor(locale_id: String, block: Lang.() -> Unit) : this(locale_id) {
      this.block()
   }

   fun defaults(block: LangBlock) =
      module(Locale.DEFAULTS, block)

   inline fun <reified T> module(noinline block: LangBlock) =
      module(T::class.qName, block)

   fun module(name: String, block: LangBlock) {
      moduleTextMap[name] = mutableMapOf<String,String>().also(block)
   }
}
