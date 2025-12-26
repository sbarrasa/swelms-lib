package com.swelms.common.collections

import kotlin.enums.EnumEntries

class EnumMap<E : Enum<E>, V> (private val map: Map<E, V>) : Map<E, V> by map {
   val enumClass = map.keys.first()::class

   constructor(
      entries: Iterable<E>,
      mapper: (E) -> V
   ) : this(entries.associateWith(mapper))

}

inline fun <E : Enum<E>, V> EnumEntries<E>.associateWith(
   mapper: (E) -> V
): EnumMap<E, V> =
   EnumMap((this as Iterable<E>).associateWith(mapper))
