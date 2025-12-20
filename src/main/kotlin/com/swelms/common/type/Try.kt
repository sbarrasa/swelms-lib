package com.swelms.common.type

object Try{
   @JvmStatic fun <T> get(block: () -> T) = tryGet(block)
   @JvmStatic fun run(block: () -> Unit) = tryRun(block)
}

fun <T> tryGet(block: () -> T): ValResult<T?> =
   try {
      ValResult.Success(value = block())
   } catch (e: Throwable) {
      ValResult.Error(error = e)
   }

fun tryRun(block: () -> Unit): ValResult<Unit> =
   try {
      block()
      ValResult.Success(value = Unit)
   } catch (e: Throwable) {
      ValResult.Error(error = e)
   }
