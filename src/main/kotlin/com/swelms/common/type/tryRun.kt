package com.swelms.common.type

fun tryRun(block: () -> Unit): Result<Unit> =
   try {
      block()
      Result.Success(value = Unit)
   } catch (e: Throwable) {
      Result.Error(error = e)
   }


inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let {block(it)}
   return this
}
