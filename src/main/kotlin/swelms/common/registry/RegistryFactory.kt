package swelms.common.registry

import swelms.common.locale.Locale
import swelms.common.locale.LocaleContext
import swelms.common.reflection.qProperty
import swelms.common.text.replaceSlots

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
         ?: throw RegistryException(Locale.text(qProperty("NOT_REGISTERED")).replaceSlots(key))
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