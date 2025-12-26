package com.swelms.common.type

fun <T> tryGet(block: () -> T): Result<T?> =
   try {
      Result.Success(value = block())
   } catch (e: Throwable) {
      Result.Error(error = e)
   }


inline infix fun <T> Result<T>.orElse(block: (Result<T>) -> Any?): Any? = value ?: block(this)
infix fun <T> Result<T>.orElse(defaultValue: Any?) = orElse { defaultValue }

