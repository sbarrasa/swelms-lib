package com.swelms.common.range

inline operator fun <reified T : Enum<T>> ClosedRange<T>.iterator(): Iterator<T> =
   enumValues<T>().slice(this.start.ordinal..this.endInclusive.ordinal).iterator()

inline fun <reified T : Enum<T>> ClosedRange<T>.count(): Int =
   this.endInclusive.ordinal - this.start.ordinal + 1