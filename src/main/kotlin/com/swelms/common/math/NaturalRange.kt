package com.swelms.common.math

class NaturalRange(
   override val start: Natural,
   override val endInclusive: Natural
) : ClosedRange<Natural>, Iterable<Natural> {

   override fun iterator() =
      (start.value..endInclusive.value)
         .map(::Natural)
         .iterator()

   fun toIntRange(): IntRange =
      start.value..endInclusive.value
}