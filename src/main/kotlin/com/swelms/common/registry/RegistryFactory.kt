package com.swelms.common.registry

import com.swelms.common.locale.localeText
import com.swelms.common.locale.replaceSlots

open class RegistryFactory<K, T>(instances: MutableMap<K,T> = mutableMapOf(),
                                 val constructors: MutableMap<K, () -> T> = mutableMapOf() )
   : Registry<K,T>(instances){

   fun register(key: K, constructor: () -> T) {
      constructors[key] = constructor
   }


   override fun unregister(key: K) {
      super.unregister(key)
      constructors.remove(key)
   }

   fun create(key: K): T {
      return constructors[key]
         ?.invoke()
         ?: throw RegistryException(localeText("NO_ELEMENT_REGISTERED").replaceSlots(key))
   }

   override operator fun get(key: K): T {
      return try {
         super.get(key)
      } catch (_ : RegistryException) {
         val instance = create(key)
         instances[key] = instance
         return instance
      }
   }

}