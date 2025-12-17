package com.swelms.common.error


sealed class Result<T>(open val value: T?, open val error: Throwable?) {
   data class Success<T>(override val value: T) : Result<T>(value, null)
   data class Error<T>(override val value: T?=null, override val error: Throwable) : Result<T>(value, error)

   infix fun orElse(block: (Result<T>) -> T): T = value ?: block(this)
   infix fun orAny(block: (Result<T>) -> Any?): Any? = value ?: block(this)

   infix fun orElse(defaultValue: T) = orElse {defaultValue}

   infix fun orAny(defaultValue: Any?) = orAny {defaultValue}

   infix fun onError(block: (Throwable) -> Unit): Result<T> {
      error?.let(block)
      return this
   }
}


