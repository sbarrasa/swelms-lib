package swelms.common.locale


typealias RegionalBlock = (MutableMap<String, Any>) -> Unit

data class Regional(
   override val locale_id: String,
   override val valueMap: MutableMap<String, Any> = mutableMapOf()
) : RegionalInterface {
   constructor(
      locale_id: String,
      block: RegionalBlock
   ) : this(locale_id) {
      block(valueMap)
   }
}