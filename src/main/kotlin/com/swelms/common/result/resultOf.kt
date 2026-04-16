package com.swelms.common.result

fun <T> resultOf(block: () -> T): Result<T?> =
      try {
         return Result.Success(block())
      } catch (e: Throwable) {
         return Result.Error(e)
      }


inline infix fun <T, R> Result<T>.valueOrElse(block: (Result<T>) -> R): R where T : R =
   when (this) {
      is Result.Success -> value
      is Result.Error -> block(this)
   }

