package com.swelms.common.enums


class EnumRange<E : Enum<E>>(
   override val start: E,
   override val endInclusive: E
) : ClosedRange<E>, Iterable<E> {
   override fun iterator(): Iterator<E> = object : Iterator<E> {
      private var current = start.ordinal
      override fun hasNext() = current <= endInclusive.ordinal
      override fun next() = start.declaringJavaClass.enumConstants[current++]
   }
}

inline operator fun <reified E : Enum<E>> E.rangeTo(other: E) = EnumRange(this, other)
