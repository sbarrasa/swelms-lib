package com.swelms.common.locale


open class RegionalBuilder(override val locale_id: String) : Regionalinterface {

   override val valueMap = mutableMapOf<String, Any>()

   val key get() = valueMap

   constructor(locale_id: String, block: RegionalBuilder.() -> Unit) : this(locale_id) {
      this.block()
   }
}