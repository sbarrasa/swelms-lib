package com.swelms.common.collections

import kotlin.reflect.KClass

class EnumMap<E : Enum<E>, V>(
   val enumClass: KClass<E>,
   private val map: Map<E, V>
) : Map<E, V> by map {

   companion object {
      inline operator fun <reified E : Enum<E>, V> invoke(mapper: (E) -> V): EnumMap<E, V> {
         val entries = enumValues<E>().associateWith(mapper)
         return EnumMap(E::class, entries)
      }
   }
}

inline fun <reified E : Enum<E>> enumMapOf(mapper: (E) -> Any) = EnumMap<E, Any> { mapper(it) }
