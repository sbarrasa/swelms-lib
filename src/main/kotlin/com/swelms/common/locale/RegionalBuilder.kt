package com.swelms.common.locale

class RegionalBuilder(localeId: String, block: RegionalBuilder.() -> Unit) : AbstractRegionalConfig {
   override val valueMap = mutableMapOf<String, Any>()
   override val locale_id = localeId

   init {
      block()
   }

   fun value(key: String, value: Any) {
      valueMap[key] = value
   }

   fun values(block: MutableMap<String, Any>.() -> Unit) {
      valueMap.apply(block)
   }
}
