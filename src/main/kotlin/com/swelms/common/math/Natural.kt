package com.swelms.common.math

import com.swelms.common.type.Restricted

class Natural(value: Int): Restricted<Int>(value, { it > 0}),
   Comparable<Natural> {

   override operator fun compareTo(other: Natural): Int =
      value.compareTo(other.value)

   operator fun plus(other: Natural) =
      Natural(value + other.value)

   operator fun minus(other: Natural) =
      Natural(value - other.value)

   operator fun times(other: Natural) =
      Natural(value * other.value)

   operator fun div(other: Natural) =
      Natural(value / other.value)

   operator fun rem(other: Natural) =
      Natural(value % other.value)

   operator fun inc() =
      Natural(value + 1)

   operator fun dec() =
      Natural(value - 1)


   operator fun rangeTo(other: Natural) =
      NaturalRange(this, other)

}

val Int.n: Natural get() = Natural(this)
