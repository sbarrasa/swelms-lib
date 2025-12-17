package com.swelms.common.error

fun <T> tryGet(block: () -> T): Result<T?> =
   try {
      Result.Success(value = block())
   } catch (e: Throwable) {
      Result.Error(error = e)
   }

