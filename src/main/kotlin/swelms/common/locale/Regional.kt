package swelms.common.locale


typealias RegionalBlock = (MutableMap<String, Any>) -> Unit

data class Regional(
   override val locale_id: String,
   val valueMap: MutableMap<String, Any> = mutableMapOf()
) : LocaleComponent {
   constructor(
      locale_id: String,
      block: RegionalBlock
   ) : this(locale_id) {
      block(valueMap)
   }
}