package com.sbarrasa.registry

open class Registry<K, T>(val instances: MutableMap<K,T> = mutableMapOf(),
                     val constructors: MutableMap<K, () -> T> = mutableMapOf() ) {

   fun register(key: K, constructor: () -> T) {
      constructors[key] = constructor
   }

   fun register(key: K, instance: T) {
      instances[key] = instance
   }

   fun unregister(key: K) {
      instances.remove(key)
      constructors.remove(key)
   }

   fun create(key: K): T {
      return constructors[key]
         ?.invoke()
         ?: throw RegistryException(key)
   }

   fun get(key: K): T {
      return instances.get(key)
         ?: run {
            val instance = create(key)
            instances.put(key, instance)
            return@run instance
         }
   }

}