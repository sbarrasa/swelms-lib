package com.swelms.common.error

fun <T> tryRun(block: () -> T): Result<Unit> =
   try {
      block()
      Result.Success(value = Unit)
   } catch (e: Throwable) {
      Result.Error(error = e)
   }

