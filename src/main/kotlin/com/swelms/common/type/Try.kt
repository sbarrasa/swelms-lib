package com.swelms.common.type

object Try{
   @JvmStatic fun <T> get(block: () -> T) = tryGet(block)
   @JvmStatic fun run(block: () -> Unit) = tryRun(block)
}

fun <T> tryGet(block: () -> T): Res<T?> =
   try {
      Res.Success(value = block())
   } catch (e: Throwable) {
      Res.Error(error = e)
   }

fun tryRun(block: () -> Unit): Res<Unit> =
   try {
      block()
      Res.Success(value = Unit)
   } catch (e: Throwable) {
      Res.Error(error = e)
   }
