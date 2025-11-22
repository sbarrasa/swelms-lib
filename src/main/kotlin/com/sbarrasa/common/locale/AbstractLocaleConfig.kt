package com.sbarrasa.common.locale

import kotlin.reflect.KClass

abstract class AbstractLocaleConfig {
   init {
      register()
   }

   protected fun <T : Any> KClass<T>.texts(block: (MutableMap<String, String>) -> Unit) {
      Locale.register(this, block)
   }

   abstract fun register()
}