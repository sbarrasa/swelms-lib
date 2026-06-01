package swelms.common.locale

import kotlinx.serialization.Serializable

@Serializable
data class Lang(
   override val locale_id: String,
   val textMap: MutableMap<String, String> = mutableMapOf()
) : LocaleComponent {

   constructor(
      locale_id: String,
      block: (MutableMap<String, String>) -> Unit
   ) : this(locale_id) {
      block(textMap)
   }
}