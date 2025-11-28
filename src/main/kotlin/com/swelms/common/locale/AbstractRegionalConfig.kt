package com.swelms.common.locale

abstract class AbstractRegionalConfig : AbstractLocaleConfig() {

   val values = mutableMapOf<String, Any>()

   override fun unload() {
      values.clear()
   }

}
