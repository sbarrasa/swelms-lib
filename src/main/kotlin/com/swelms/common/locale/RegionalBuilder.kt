package com.swelms.common.locale

open class RegionalBuilder(override val locale_id: String) : Regionalinterface {
   override val valueMap = mutableMapOf<String, Any>()

   constructor(locale_id: String, block: (MutableMap<String, Any>) -> Unit) : this(locale_id) {
      block(valueMap)
   }
}