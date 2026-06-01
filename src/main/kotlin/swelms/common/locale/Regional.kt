package swelms.common.locale


data class Regional(
   override val locale_id: String,
   val valueMap: MutableMap<String, Any> = mutableMapOf()
) : LocaleConfig {
   constructor(
      locale_id: String,
      block: (MutableMap<String, Any>) -> Unit
   ) : this(locale_id) {
      block(valueMap)
   }
}