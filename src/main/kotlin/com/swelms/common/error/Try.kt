package com.swelms.common.error

object Try{
   @JvmStatic infix fun <T> get(block: () -> T) = tryGet(block)
   @JvmStatic infix fun run(block: () -> Unit) = tryRun(block)
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
