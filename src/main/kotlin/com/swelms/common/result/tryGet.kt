package com.swelms.common.result

fun <T> tryGet(block: () -> T): Result<T?> =
      try {
         return Result.Success(block())
      } catch (e: Exception) {
         return Result.Error(e)
      }


inline infix fun <T, R> Result<T>.orElse(block: (Result<T>) -> R): R where T : R =
   when (this) {
      is Result.Success -> value
      is Result.Error -> block(this)
   }

inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let {block(it)}
   return this
}
