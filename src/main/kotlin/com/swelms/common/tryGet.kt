package com.swelms.common

fun <T> tryGet(attempts: Int = 1, block: () -> T): Result<T?> {
   require(attempts >= 1) { "times must be positive number" }
   var lastError: Throwable? = null
   repeat(attempts) {
      try {
         return Result.Success(block())
      } catch (e: Throwable) {
         lastError = e
      }
   }
   return Result.Error(lastError!!)
}

inline infix fun <T> Result<T>.orElse(block: (Result<T>) -> T): T = value ?: block(this)
infix fun <T> Result<T>.orElse(defaultValue: T) = orElse { defaultValue }

inline infix fun <T> Result<T>.orAny(block: (Result<T>) -> Any?): Any? = value ?: block(this)
infix fun <T> Result<T>.orAny(defaultValue: Any?) = orAny { defaultValue }

inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let {block(it)}
   return this
}
