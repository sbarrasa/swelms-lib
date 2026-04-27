package com.swelms.common.type

fun <T> resultOf(block: () -> T): Result<T?> =
      try {
         return Result.Success(block())
      } catch (e: Throwable) {
         return Result.Fail(e)
      }


infix fun <T> Result<T>.orElse(block: (Result.Fail) -> T): Result<T?> =
    when (this) {
        is Result.Success -> this
        is Result.Fail -> resultOf { block(this) }
    }
