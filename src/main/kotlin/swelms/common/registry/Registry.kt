package swelms.common.registry

import swelms.common.locale.Locale
import swelms.common.reflection.qProperty
import swelms.common.text.replaceSlots

open class Registry<K, T>(val instances: MutableMap<K,T> = mutableMapOf()) {

   fun register(key: K, instance: T) {
      instances[key] = instance
   }

   open fun unregister(key: K) {
      instances.remove(key)
   }

   open operator fun get(key: K): T = instances[key]
      ?: throw RegistryException(Locale.text(qProperty("NO_ELEMENT_REGISTERED")).replaceSlots(key))

}