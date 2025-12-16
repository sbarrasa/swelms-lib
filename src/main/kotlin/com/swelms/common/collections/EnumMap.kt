package com.swelms.common.collections


class EnumMap<E : Enum<E>, V> (private val map: Map<E, V>) : Map<E, V> by map {
   val enumClass = map.keys.first()::class

   companion object {
      inline operator fun <reified E : Enum<E>, V> invoke(mapper: (E) -> V) =
         EnumMap(enumValues<E>().associateWith(mapper))
   }
}


inline fun <reified E : Enum<E>, V> Iterable<E>.associateTo(mapper: (E) -> V): EnumMap<E, V> =
   EnumMap(this.associateWith(mapper))

fun Catalog.put(map: EnumMap<*,*>) = put(map.enumClass, map)