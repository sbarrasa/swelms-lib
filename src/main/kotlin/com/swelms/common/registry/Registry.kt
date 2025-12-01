package com.swelms.common.registry

import com.swelms.common.locale.localeText
import com.swelms.common.locale.replaceSlots

open class Registry<K, T>(val instances: MutableMap<K,T> = mutableMapOf()) {

   fun register(key: K, instance: T) {
      instances[key] = instance
   }

   open fun unregister(key: K) {
      instances.remove(key)
   }

   open operator fun get(key: K): T = instances[key]
      ?: throw RegistryException(localeText("NO_ELEMENT_REGISTERED").replaceSlots(key))

}