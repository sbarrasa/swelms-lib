package swelms.common.locale

import kotlinx.serialization.Serializable
import swelms.common.reflection.qName

typealias LangBlock = (MutableMap<String,String>) -> Unit

@Serializable
data class Lang(override val locale_id: String,
                val moduleTextMap: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
) : LocaleComponent {
   constructor(locale_id: String, block: Lang.() -> Unit) : this(locale_id) {
      this.block()
   }

   companion object {
      const val DEFAULTS = "defaults"
   }


   fun defaults(block: LangBlock) =
      component(DEFAULTS, block)

   inline fun <reified T> component(noinline block: LangBlock) =
      component(T::class.qName, block)

   fun component(name: String, block: LangBlock) {
      moduleTextMap[name] = mutableMapOf<String,String>().also(block)
   }
}
