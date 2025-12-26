package com.swelms.common.enums

import kotlin.enums.EnumEntries

class EnumMap<E : Enum<E>, V>(private val map: Map<E, V>) :
      EnumContainer<E>, Map<E, V> by map {
   override val enumClass get() = keys.first()::class
}

inline fun <E : Enum<E>, V> EnumEntries<E>.associateWith(
   mapper: (E) -> V
): EnumMap<E, V> =
   EnumMap((this as Iterable<E>).associateWith(mapper))


inline fun <reified E : Enum<E>, V> enumMap(
   crossinline mapper: (E) -> V
): EnumMap<E, V> =
   EnumMap(enumValues<E>().associateWith(mapper))
