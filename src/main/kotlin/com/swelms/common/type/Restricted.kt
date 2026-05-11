package com.swelms.common.type

open class Restricted<T> (val value: T, condition: (T) -> Boolean) {
   init {
      require(condition(value)) { "value $value is invalid" }
   }
}