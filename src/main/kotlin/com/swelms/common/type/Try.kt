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

inline infix fun <T> Result<T>.orElse(block: (Result<T>) -> T): T = value ?: block(this)
infix fun <T> Result<T>.orElse(defaultValue: T) = orElse { defaultValue }

inline infix fun <T> Result<T>.orAny(block: (Result<T>) -> Any?): Any? = value ?: block(this)
infix fun <T> Result<T>.orAny(defaultValue: Any?) = orAny { defaultValue }

inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let(block)
   return this
}
