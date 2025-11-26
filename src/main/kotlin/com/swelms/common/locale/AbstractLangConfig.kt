package com.swelms.common.locale

import kotlin.reflect.KClass


abstract class AbstractLangConfig: AbstractLocaleConfig {
   val textsByClass = mutableMapOf<String, Map<String, String>>()

   fun <T : Any> KClass<T>.register(block: (MutableMap<String, String>) -> Unit) {
      val map = mutableMapOf<String, String>()
      block(map)
      register(this, map)
   }

   fun register(k: KClass<*>, map: Map<String, String>) {
      textsByClass[Locale.cleanKey(k)] = map
   }
}
