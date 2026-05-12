package com.swelms.common.math

@JvmInline
value class Natural(val value: Int): Comparable<Natural> {
   init {
      if (value < 1) throw ArithmeticException("$value of naturals must be positive")
   }

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
