package com.sbarrasa.common.locale

import com.sbarrasa.common.collections.StringMap
import kotlin.reflect.KClass

abstract class AbstractLangConfig {
   val textsByClass = mutableMapOf<KClass<*>, StringMap>()

   abstract fun register()

   fun <T : Any> KClass<T>.register(block: (MutableMap<String, String>) -> Unit) {
      val map = mutableMapOf<String, String>()
      block(map)
      register(this, map)
   }

   fun register(k: KClass<*>, map: MutableMap<String, String>) {
      textsByClass[k] = map
   }

}
