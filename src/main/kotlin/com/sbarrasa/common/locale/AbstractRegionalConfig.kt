package com.sbarrasa.common.locale

abstract class AbstractRegionalConfig : AbstractLocaleConfig {
   val values = mutableMapOf<String, Any>()

   fun register(block: (MutableMap<String, Any>) -> Unit) {
      val map = mutableMapOf<String, Any>()
      block(map)
      values.putAll(map)
   }

   fun register(key: String, value: Any) {
      values[key] = value
   }
}
