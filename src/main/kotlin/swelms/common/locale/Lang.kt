package swelms.common.locale

import kotlinx.serialization.Serializable
import swelms.common.collections.StringMap


@Serializable
data class Lang(override val locale_id: String,
                val textMap: StringMap = mutableMapOf()
) : LocaleComponent {
   constructor(locale_id: String, vararg pairs: Pair<String, String>)
         : this(locale_id, mutableMapOf(*pairs))

}
