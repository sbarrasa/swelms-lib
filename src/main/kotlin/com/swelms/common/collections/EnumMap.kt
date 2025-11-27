package com.swelms.common.collections

import kotlin.reflect.KClass

class EnumMap<E : Enum<E>, V> (private val map: Map<E, V>) : Map<E, V> by map {
   val enumClass = map.keys.first()::class

   companion object {
      inline operator fun <reified E : Enum<E>, V> invoke(mapper: (E) -> V) =
         EnumMap(enumValues<E>().associateWith(mapper))
   }
}

inline fun <reified E : Enum<E>, V> KClass<E>.mapTo(mapper: (E) -> V): EnumMap<E, V> =
   EnumMap(enumValues<E>().associateWith(mapper))
