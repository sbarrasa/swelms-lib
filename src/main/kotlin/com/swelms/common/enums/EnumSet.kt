package com.swelms.common.enums


class EnumSet<E : Enum<E>>(
   private val set: Set<E>
) : Set<E> by set, EnumContainer<E> {

   constructor(elements: Iterable<E>) : this(elements.toSet())
   constructor(vararg elements: E) : this(elements.toSet())

   override val enumClass get() = set.first()::class
}


inline fun <E : Enum<E>, V> EnumSet<E>.associateWith(
   mapper: (E) -> V
): EnumMap<E, V> = EnumMap((this as Iterable<E>).associateWith(mapper))