package com.swelms.common.result

fun <T> tryGet(attempts: Int = 1, block: () -> T): Result<T?> {
   require(attempts >= 1) { "attempts must be positive number" }
   val errors = mutableListOf<Throwable>()
   repeat(attempts) {
      try {
         return Result.Success(block())
      } catch (e: Exception) {
         errors.add(e)
      }
   }
   return if(attempts==1)
      Result.Error(errors.last())
   else
      Result.Error(AccumulatedException(errors))
}

inline infix fun <T> Result<T>.orElse(block: (Result<T>) -> T): T = value ?: block(this)
infix fun <T> Result<T>.orElse(defaultValue: T) = orElse { defaultValue }

inline infix fun <T> Result<T>.orAny(block: (Result<T>) -> Any?): Any? = value ?: block(this)
infix fun <T> Result<T>.orAny(defaultValue: Any?) = orAny { defaultValue }

inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let {block(it)}
   return this
}
