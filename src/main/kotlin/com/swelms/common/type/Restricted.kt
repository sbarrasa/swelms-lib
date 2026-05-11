package com.swelms.common.type

open class Restricted<T> (val value: T, condition: (T) -> Boolean) {
   init {
      require(condition(value)) { "value $value is invalid" }
   }

   override fun equals(other: Any?): Boolean =
      when (other) {
         is Restricted<*> -> value == other.value
         else -> value == other
      }

   override fun hashCode(): Int =
      value.hashCode()

   override fun toString(): String =
      value.toString()
}