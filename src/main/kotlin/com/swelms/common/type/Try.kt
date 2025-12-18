package com.swelms.common.type

object Try{
   @JvmStatic fun <T> get(block: () -> T) = tryGet(block)
   @JvmStatic fun run(block: () -> Unit) = tryRun(block)
}

fun <T> tryGet(block: () -> T): Result<T?> =
   try {
      Result.Success(value = block())
   } catch (e: Throwable) {
      Result.Error(error = e)
   }

fun tryRun(block: () -> Unit): Result<Unit> =
   try {
      block()
      Result.Success(value = Unit)
   } catch (e: Throwable) {
      Result.Error(error = e)
   }
